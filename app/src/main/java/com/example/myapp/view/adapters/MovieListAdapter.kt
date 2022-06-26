package com.example.myapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.myapp.databinding.MovieItemBinding
import com.example.myapp.model.Movie
import com.example.myapp.view.viewholders.MovieVH

class MovieListAdapter(
    private val openMovieDetail: (Movie?) -> Unit
) : ListAdapter<Movie, MovieVH>(diff) {

    companion object {
        val diff = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie) =
                false

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie) =
                false
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        return MovieVH(MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        val movie = getItem(position)
        holder.bind(movie, openMovieDetail)
    }

}