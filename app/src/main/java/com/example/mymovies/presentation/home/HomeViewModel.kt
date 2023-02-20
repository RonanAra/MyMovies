package com.example.mymovies.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovies.domain.usecase.GetPopularUseCase
import com.example.mymovies.domain.usecase.GetTopRatedUseCase
import com.example.mymovies.domain.usecase.GetUpComingUseCase
import com.example.mymovies.utils.launchSuspendFun
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNowPlayingUseCase: GetPopularUseCase,
    private val getPopularUseCase: GetPopularUseCase,
    private val getUpComingUseCase: GetUpComingUseCase,
    private val getTopRatedUseCase: GetTopRatedUseCase,
) : ViewModel() {

    private val _state = MutableLiveData<HomeState>()
    val state: LiveData<HomeState> = _state

    fun handleIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.LoadList -> handleLoadView()
        }
    }

    private fun handleLoadView() {
        handleTopRatedMovies()
        handleGetNowPlayingMovies()
        handleGetPopularMovies()
        handleGetUpComingMovies()
    }

    private fun handleGetNowPlayingMovies() {
        viewModelScope.launchSuspendFun(
            blockToRun = {
                getNowPlayingUseCase()
            },
            onLoading = { loading ->
                _state.value = HomeState.Loading(loading)
            },
            onSuccess = { list ->
                _state.value = HomeState.LoadNowPlayingList(list)
            },
        )
    }

    private fun handleGetPopularMovies() {
        viewModelScope.launchSuspendFun(
            blockToRun = {
                getPopularUseCase()
            },
            onLoading = { loading ->
                _state.value = HomeState.Loading(loading)
            },
            onSuccess = { list ->
                _state.value = HomeState.LoadPopularList(list)
            },
        )
    }

    private fun handleTopRatedMovies() {
        viewModelScope.launchSuspendFun(
            blockToRun = {
                getTopRatedUseCase()
            },
            onLoading = { loading ->
                _state.value = HomeState.Loading(loading)
            },
            onSuccess = { list ->
                _state.value = HomeState.LoadTopRatedList(list)
            },
        )
    }

    private fun handleGetUpComingMovies() {
        viewModelScope.launchSuspendFun(
            blockToRun = {
                getUpComingUseCase()
            },
            onLoading = { loading ->
                _state.value = HomeState.Loading(loading)
            },
            onSuccess = { list ->
                _state.value = HomeState.LoadUpComingList(list)
            },
        )
    }
}