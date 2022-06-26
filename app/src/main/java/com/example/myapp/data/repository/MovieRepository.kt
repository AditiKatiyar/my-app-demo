package com.example.myapp.data.repository

import com.example.myapp.data.DummyData
import com.example.myapp.model.Movie
import com.example.myapp.model.MovieResponse
import com.google.gson.Gson
import kotlinx.coroutines.delay
import javax.inject.Inject

class MovieRepository @Inject constructor() {

    suspend fun getMovies(): List<Movie> {
        delay(2000)
        val x = Gson().fromJson(DummyData().data, MovieResponse::class.java)
        return x.results
    }
}