package com.alif.movieapps.ui.show

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alif.movieapps.databinding.FragmentShowBinding
import com.alif.movieapps.viewmodel.ViewModelFactory

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[ShowViewModel::class.java]

            val showAdapter = ShowAdapter()


            with(fragmentShowBinding.rvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = showAdapter
                val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
                addItemDecoration(dividerItemDecoration)
            }

            fragmentShowBinding.progressBar.visibility = View.VISIBLE
            viewModel.getShow().observe(viewLifecycleOwner, Observer { shows ->
                fragmentShowBinding.progressBar.visibility = View.GONE
                showAdapter.setShow(shows!!)
            })
        }
    }
}