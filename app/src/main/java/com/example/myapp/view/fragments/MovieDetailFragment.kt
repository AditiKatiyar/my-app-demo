package com.example.myapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.myapp.databinding.FragmentMovieDetailBinding
import com.example.myapp.loadImage
import com.example.myapp.model.Movie
import com.example.myapp.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.selectedMovieDetail.collect { movie ->
                    movie?.let { setData(it) }
                }
            }
        }
    }

    private fun setData(movie: Movie) {
        binding.apply {
            title.text = movie.title
            image.loadImage(movie.imageUrl)
            releaseDate.text = movie.releaseDate
            rating.text = movie.rating.toString()
            popularity.text = movie.popularity.toString()
            overview.text = movie.overview
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}