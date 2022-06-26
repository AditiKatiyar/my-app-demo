package com.example.myapp.presentation.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.MovieItemBinding
import com.example.myapp.loadImage
import com.example.myapp.presentation.MovieViewData

class MovieVH(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: MovieViewData?, openMovieDetail: (MovieViewData?) -> Unit) {
        binding.apply {
            title.text = movie?.name
            description.text = movie?.overview
            image.loadImage(movie?.imageUrl)
            root.setOnClickListener { openMovieDetail(movie) }
        }
    }
}
