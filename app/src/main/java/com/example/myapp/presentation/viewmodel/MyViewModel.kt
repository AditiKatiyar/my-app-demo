package com.example.myapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapp.presentation.MovieViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor() : ViewModel() {

    val selectedMovieDetail = MutableStateFlow<MovieViewData?>(null)

    fun setSelectedMovie(movie: MovieViewData?) {
        selectedMovieDetail.update { movie }
    }
}