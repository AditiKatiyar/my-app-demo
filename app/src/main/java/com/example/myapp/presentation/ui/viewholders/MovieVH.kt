package com.example.myapp.presentation.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.MovieItemBinding
import com.example.myapp.loadImage
import com.example.myapp.presentation.Movie

class MovieVH(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie?, openMovieDetail: (Movie?) -> Unit) {
        binding.apply {
            title.text = movie?.title
            description.text = movie?.overview
            image.loadImage(movie?.imageUrl)
            root.setOnClickListener { openMovieDetail(movie) }
        }
    }
}
