package com.alif.movieapps.ui.favorite.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alif.movieapps.R
import com.alif.movieapps.databinding.FragmentMovieFavoriteBinding
import com.alif.movieapps.ui.entity.adapter.EntityAdapter
import com.alif.movieapps.ui.entity.viewmodel.EntityViewModel
import com.alif.movieapps.viewmodel.ViewModelFactory

class MovieFavoriteFragment : Fragment() {

    private lateinit var movieFavoriteFragmentBinding: FragmentMovieFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        movieFavoriteFragmentBinding = FragmentMovieFavoriteBinding.inflate(layoutInflater, container, false)
        return movieFavoriteFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[EntityViewModel::class.java]

            val movieAdapter = EntityAdapter()

            bindRv(movieAdapter)

            viewModel.getFavoritedMovie().observe( requireActivity(), Observer { movies ->
                if(movies.size > 0) {
                    movieFavoriteFragmentBinding.fragmentStateMovie.visibility = View.GONE
                    movieAdapter.initialize(movies, viewModel)
                } else {
                    movieFavoriteFragmentBinding.rvMovie.visibility = View.GONE
                    movieFavoriteFragmentBinding.fragmentStateMovie.visibility = View.VISIBLE

                }
            })

        }
    }


    private fun bindRv(movieAdapter: EntityAdapter) {
        with(movieFavoriteFragmentBinding.rvMovie) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
            val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }
    }

}