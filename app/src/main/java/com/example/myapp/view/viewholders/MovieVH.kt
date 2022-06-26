package com.example.myapp.view.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.AppConstants.Companion.BASE_PATH
import com.example.myapp.databinding.MovieItemBinding
import com.example.myapp.loadImage
import com.example.myapp.model.Movie

class MovieVH(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie?, openMovieDetail: (Movie?) -> Unit) {
        binding.apply {
            title.text = movie?.title
            description.text = movie?.overview
            image.loadImage(movie?.let { BASE_PATH + it.imageUrl })
            root.setOnClickListener { openMovieDetail(movie) }
        }
    }
}
