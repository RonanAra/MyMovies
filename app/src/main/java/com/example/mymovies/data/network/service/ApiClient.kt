package com.example.mymovies.data.network.service

import com.example.mymovies.data.network.model.ListResponse
import retrofit2.http.GET

interface ApiClient {

    @GET("movie/now_playing")
    suspend fun getNowPlayingList(): ListResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedList(): ListResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingList(): ListResponse

    @GET("movie/popular")
    suspend fun getPopularList(): ListResponse
}