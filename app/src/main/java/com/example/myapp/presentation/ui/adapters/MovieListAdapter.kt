package com.example.myapp.presentation.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.myapp.databinding.MovieItemBinding
import com.example.myapp.presentation.MovieViewData
import com.example.myapp.presentation.ui.viewholders.MovieVH

class MovieListAdapter(
    private val openMovieDetail: (MovieViewData?) -> Unit
) : ListAdapter<MovieViewData, MovieVH>(diff) {

    companion object {
        val diff = object : DiffUtil.ItemCallback<MovieViewData>() {
            override fun areItemsTheSame(oldItem: MovieViewData, newItem: MovieViewData) =
                false

            override fun areContentsTheSame(oldItem: MovieViewData, newItem: MovieViewData) =
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