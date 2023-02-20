package com.example.mymovies.data.network.model

import com.example.mymovies.domain.entity.MovieListModel
import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    val id: String,
    @SerializedName("poster_path")
    val image: String,
) {
    fun toMovieModel(): MovieListModel {
        return MovieListModel(imageUrl = image)
    }
}