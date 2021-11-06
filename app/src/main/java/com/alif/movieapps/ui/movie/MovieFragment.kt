package com.alif.movieapps.ui.movie

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alif.movieapps.databinding.FragmentMovieBinding
import com.alif.movieapps.ui.entity.adapter.EntityAdapter
import com.alif.movieapps.ui.entity.viewmodel.EntityViewModel
import com.alif.movieapps.viewmodel.ViewModelFactory
import com.alif.movieapps.vo.Status

class MovieFragment : Fragment() {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    @SuppressLint("ShowToast")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[EntityViewModel::class.java]

            val movieAdapter = EntityAdapter()

            bindRv(movieAdapter)

            viewModel.getMovie().observe( viewLifecycleOwner, Observer { movies ->

                when(movies.status) {
                    Status.LOADING -> fragmentMovieBinding.progressBar.visibility = View.VISIBLE

                    Status.SUCCESS -> {
                        fragmentMovieBinding.progressBar.visibility = View.GONE
                        movieAdapter.initialize(movies.data, viewModel)
                        movieAdapter.notifyDataSetChanged()
                    }

                    Status.ERROR -> {
                        fragmentMovieBinding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
                    }
                }
            })

        }
    }

    private fun bindRv(movieAdapter: EntityAdapter) {
        with(fragmentMovieBinding.rvMovie) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
            val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }
    }
}