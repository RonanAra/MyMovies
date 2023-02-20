package com.example.mymovies.presentation.home

import com.example.mymovies.domain.entity.MovieListModel

sealed class HomeState {
    data class Loading(val loading: Boolean): HomeState()
    data class LoadNowPlayingList(val list: List<MovieListModel>): HomeState()
    data class LoadPopularList(val list: List<MovieListModel>): HomeState()
    data class LoadUpComingList(val list: List<MovieListModel>): HomeState()
    data class LoadTopRatedList(val list: List<MovieListModel>): HomeState()
}