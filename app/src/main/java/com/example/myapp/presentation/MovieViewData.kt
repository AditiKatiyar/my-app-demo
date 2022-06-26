package com.example.myapp.presentation

data class MovieViewData(
    val name: String,
    val overview: String,
    val releaseDate: String,
    val rating: Float,
    val popularity: Float,
    val imageUrl: String? = null
)