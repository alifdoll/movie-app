package com.alif.movieapps.ui.favorite.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alif.movieapps.R
import com.alif.movieapps.databinding.FragmentFavoriteBinding
import com.alif.movieapps.ui.favorite.adapter.SectionsPagerAdapter

class FavoriteFragment : Fragment() {

    private lateinit var fragmentFavoriteBinding: FragmentFavoriteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFavoriteBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)

        val sectionsPagerAdapter = SectionsPagerAdapter(requireActivity(), childFragmentManager)
        fragmentFavoriteBinding.viewPager.adapter = sectionsPagerAdapter
        fragmentFavoriteBinding.tabs.setupWithViewPager(fragmentFavoriteBinding.viewPager)
        return fragmentFavoriteBinding.root
    }
}