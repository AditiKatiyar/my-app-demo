package com.example.myapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.model.Movie
import com.example.myapp.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    val selectedMovieDetail = MutableStateFlow<Movie?>(null)
    val moviesList = MutableStateFlow<List<Movie>?>(null)

    fun setSelectedMovie(movie: Movie?) {
        selectedMovieDetail.update { movie }
    }

    fun loadMovies() {
        viewModelScope.launch {
            val movies = repository.getMovies()
            moviesList.emit(movies)
        }
    }
}