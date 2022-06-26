package com.example.myapp.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.R
import com.example.myapp.databinding.FragmentMoviesListBinding
import com.example.myapp.presentation.MovieViewData
import com.example.myapp.presentation.ui.adapters.MovieListAdapter
import com.example.myapp.presentation.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesListFragment : Fragment() {

    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieListAdapter: MovieListAdapter

    private val viewModel: MyViewModel by activityViewModels()

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
        /*viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.text.collect {
                    binding.textLabel.text = it
                }
            }
        }*/
    }

    private fun initView() {
        movieListAdapter = MovieListAdapter { movie -> openMovieDetail(movie) }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(
                requireActivity()
            )
            adapter = movieListAdapter
        }
        val x = listOf<MovieViewData>(
            MovieViewData("bbb", "nnnnn", "12-2-2020", 3.4F, 45F)
        )
        movieListAdapter.submitList(x)
    }

    private fun openMovieDetail(movie: MovieViewData?) {
        viewModel.setSelectedMovie(movie)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frag_container, MovieDetailFragment()).addToBackStack("").commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}