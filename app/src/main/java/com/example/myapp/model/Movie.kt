package com.example.myapp.model

data class Movie(
    val title: String,
    val overview: String,
    val releaseDate: String,
    val rating: Float,
    val popularity: Float,
    val imageUrl: String? = null
)