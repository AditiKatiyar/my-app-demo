package com.example.myapp.repository

import com.example.myapp.presentation.Movie
import kotlinx.coroutines.delay
import javax.inject.Inject

class MovieRepository @Inject constructor() {

    suspend fun getMovies(): List<Movie> {
        delay(2000)
        val x = listOf<Movie>(
            Movie("bbb", "nnnnn", "12-2-2020", 3.4F, 45F),
            Movie("s", "nnnnn", "12-2-2020", 3.4F, 45F),
            Movie("bbfb", "nbbnnnn", "12-2-2020", 3.4F, 45F),
            Movie("bfbb", "nnnnn", "12-2-2520", 3.4F, 45F),
            Movie("bbbb", "nnnnn", "12-2-2020", 3.4F, 45F)
        )
        return x
    }
}