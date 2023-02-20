package com.example.mymovies.domain.usecase

import com.example.mymovies.data.network.repository.HomeRepository
import com.example.mymovies.domain.entity.MovieListModel
import javax.inject.Inject

class GetUpComingUseCaseRemote @Inject constructor(
    private val homeRepository: HomeRepository
) : GetUpComingUseCase {

    override suspend fun invoke(): List<MovieListModel> {
        return homeRepository.getUpcomingList().results.map { it.toMovieModel() }
    }
}