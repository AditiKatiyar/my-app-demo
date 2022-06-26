package com.example.myapp.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val title: String,

    val overview: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("vote_average")
    val rating: Float,

    val popularity: Float,

    @SerializedName("poster_path")
    val imageUrl: String? = null
)