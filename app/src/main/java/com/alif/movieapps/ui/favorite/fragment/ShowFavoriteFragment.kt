package com.alif.movieapps.ui.favorite.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alif.movieapps.R
import com.alif.movieapps.databinding.FragmentShowFavoriteBinding
import com.alif.movieapps.ui.entity.adapter.EntityAdapter
import com.alif.movieapps.ui.entity.viewmodel.EntityViewModel
import com.alif.movieapps.viewmodel.ViewModelFactory

class ShowFavoriteFragment : Fragment() {

    private lateinit var fragmentShowFavoriteBinding: FragmentShowFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentShowFavoriteBinding = FragmentShowFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentShowFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[EntityViewModel::class.java]

            val showAdapter = EntityAdapter()

            bindRv(showAdapter)

            viewModel.getFavoritedShow().observe( viewLifecycleOwner, Observer { shows ->
                if(shows.size > 0) {
                    fragmentShowFavoriteBinding.fragmentStateShow.visibility = View.GONE
                    showAdapter.initialize(shows, viewModel)
                } else {
                    fragmentShowFavoriteBinding.rvShow.visibility = View.GONE
                    fragmentShowFavoriteBinding.fragmentStateShow.visibility = View.VISIBLE

                }
            })

        }

    }



    private fun bindRv(showAdapter: EntityAdapter) {
        with(fragmentShowFavoriteBinding.rvShow) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = showAdapter
            val dividerItemDecoration = DividerItemDecoration(requireContext(), androidx.recyclerview.widget.DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }
    }

}