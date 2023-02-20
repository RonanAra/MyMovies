package com.example.mymovies.data.network.repository

import com.example.mymovies.data.network.model.ListResponse
import com.example.mymovies.data.network.service.ApiClient
import javax.inject.Inject

interface HomeRepository {
    suspend fun getNowPlayingList(): ListResponse
    suspend fun getTopRatedList(): ListResponse
    suspend fun getUpcomingList(): ListResponse
    suspend fun getPopularList(): ListResponse
}

class HomeRepositoryImpl @Inject constructor(
    private val service: ApiClient
) : HomeRepository {

    override suspend fun getNowPlayingList(): ListResponse = service.getNowPlayingList()

    override suspend fun getTopRatedList(): ListResponse = service.getTopRatedList()

    override suspend fun getUpcomingList(): ListResponse = service.getUpcomingList()

    override suspend fun getPopularList(): ListResponse = service.getPopularList()
}