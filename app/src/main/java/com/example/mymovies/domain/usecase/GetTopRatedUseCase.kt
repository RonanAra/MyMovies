package com.example.mymovies.domain.usecase

import com.example.mymovies.domain.entity.MovieListModel

interface GetTopRatedUseCase {
    suspend operator fun invoke(): List<MovieListModel>
}