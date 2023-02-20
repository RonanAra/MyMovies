package com.example.mymovies.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mymovies.databinding.FragmentHomeBinding
import com.example.mymovies.domain.entity.MovieListModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()

    private val onDisplayAdapter by lazy { HomeAdapter() }
    private val upComingAdapter by lazy { HomeAdapter() }
    private val popularAdapter by lazy { HomeAdapter() }
    private val topRatedAdapter by lazy { HomeAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(
            view,
            savedInstanceState
        )
        setView()
        loadList()
        setObservers()
        setupAdapters()
    }

    private fun setView() = binding.run {
        homeSrl.isEnabled = false
    }

    private fun setupAdapters() = binding.run {
        rcyOnDisplay.adapter = onDisplayAdapter
        rcyMorePopular.adapter = popularAdapter
        rcyBestMovies.adapter = topRatedAdapter
        rcyComing.adapter = upComingAdapter
    }

    private fun setObservers() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is HomeState.LoadPopularList -> showPopularList(state.list)
                is HomeState.Loading -> showLoading(state.loading)
                is HomeState.LoadNowPlayingList -> showListOnDisplay(state.list)
                is HomeState.LoadTopRatedList -> showTopRatedList(state.list)
                is HomeState.LoadUpComingList -> showUpComingList(state.list)
            }
        }
    }

    private fun showLoading(loading: Boolean) = binding.run {
        homeSrl.isEnabled = loading
        homeSrl.isRefreshing = loading
    }

    private fun showListOnDisplay(list: List<MovieListModel>) {
        onDisplayAdapter.list = list
    }

    private fun showPopularList(list: List<MovieListModel>) {
        popularAdapter.list = list
    }

    private fun showTopRatedList(list: List<MovieListModel>) {
        topRatedAdapter.list = list
    }

    private fun showUpComingList(list: List<MovieListModel>) {
        upComingAdapter.list = list
    }

    private fun loadList() {
        viewModel.handleIntent(HomeIntent.LoadList)
    }
}