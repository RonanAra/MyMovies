package com.example.mymovies.domain.usecase

import com.example.mymovies.data.network.repository.HomeRepository
import com.example.mymovies.domain.entity.MovieListModel
import javax.inject.Inject

class GetTopRatedUseCaseRemote @Inject constructor(
    private val homeRepository: HomeRepository
) : GetTopRatedUseCase {
    override suspend fun invoke(): List<MovieListModel> {
        return homeRepository.getTopRatedList().results.map { it.toMovieModel() }
    }
}