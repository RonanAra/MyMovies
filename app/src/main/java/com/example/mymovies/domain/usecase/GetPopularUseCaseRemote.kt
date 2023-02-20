package com.example.mymovies.domain.usecase

import com.example.mymovies.data.network.repository.HomeRepository
import com.example.mymovies.domain.entity.MovieListModel
import javax.inject.Inject

class GetPopularUseCaseRemote @Inject constructor(
    private val homeRepository: HomeRepository
) : GetPopularUseCase {
    override suspend fun invoke(): List<MovieListModel> {
        return homeRepository.getPopularList().results.map { it.toMovieModel() }
    }
}