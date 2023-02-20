package com.example.mymovies.domain.usecase

import com.example.mymovies.data.network.repository.HomeRepository
import com.example.mymovies.domain.entity.MovieListModel
import javax.inject.Inject

class GetNowPlayingUseCaseRemote @Inject constructor(
    private val repository: HomeRepository
) : GetNowPlayingUseCase {
    override suspend fun invoke(): List<MovieListModel> {
        return repository.getNowPlayingList().results.map { it.toMovieModel() }
    }
}