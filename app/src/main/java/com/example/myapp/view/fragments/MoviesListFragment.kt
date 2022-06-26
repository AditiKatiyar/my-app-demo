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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.R
import com.example.myapp.databinding.FragmentMoviesListBinding
import com.example.myapp.model.Movie
import com.example.myapp.view.adapters.MovieListAdapter
import com.example.myapp.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MoviesListFragment : Fragment() {

    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieListAdapter: MovieListAdapter

    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeMoviesList()
        viewModel.loadMovies()
    }

    private fun initView() {
        movieListAdapter = MovieListAdapter { movie -> openMovieDetail(movie) }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(
                requireActivity()
            )
            adapter = movieListAdapter
        }
    }

    private fun observeMoviesList() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.moviesList.collect { movie ->
                    movie?.let { movieListAdapter.submitList(it) }
                }
            }
        }
    }

    private fun openMovieDetail(movie: Movie?) {
        viewModel.setSelectedMovie(movie)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frag_container, MovieDetailFragment()).addToBackStack("").commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}