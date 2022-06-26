package com.example.myapp.presentation

data class Movie(
    val title: String,
    val overview: String,
    val releaseDate: String,
    val rating: Float,
    val popularity: Float,
    val imageUrl: String? = null
)