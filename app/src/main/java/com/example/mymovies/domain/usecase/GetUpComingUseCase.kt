package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.entity.MovieListModel

interface GetUpComingUseCase {
    suspend operator fun invoke(): List<MovieListModel>
}