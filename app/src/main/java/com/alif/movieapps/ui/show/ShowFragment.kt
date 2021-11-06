package com.alif.movieapps.ui.show

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alif.movieapps.databinding.FragmentShowBinding
import com.alif.movieapps.ui.entity.adapter.EntityAdapter
import com.alif.movieapps.ui.entity.viewmodel.EntityViewModel
import com.alif.movieapps.viewmodel.ViewModelFactory
import com.alif.movieapps.vo.Status

class ShowFragment : Fragment() {

    private lateinit var fragmentShowBinding: FragmentShowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentShowBinding = FragmentShowBinding.inflate(layoutInflater, container, false)
        return fragmentShowBinding.root
    }

    @SuppressLint("ShowToast")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[EntityViewModel::class.java]

            val showAdapter = EntityAdapter()

            bindRv(showAdapter)

            viewModel.getShow().observe(viewLifecycleOwner, Observer { shows ->

                when(shows.status) {
                    Status.LOADING -> fragmentShowBinding.progressBar.visibility = View.VISIBLE

                    Status.SUCCESS -> {
                        fragmentShowBinding.progressBar.visibility = View.GONE
                        showAdapter.initialize(shows.data, viewModel)
                        showAdapter.notifyDataSetChanged()
                    }

                    Status.ERROR -> {
                        fragmentShowBinding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
                    }
                }

            })
        }
    }

    private fun bindRv(showAdapter: EntityAdapter) {
        with(fragmentShowBinding.rvShow) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = showAdapter
            val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }
    }
}