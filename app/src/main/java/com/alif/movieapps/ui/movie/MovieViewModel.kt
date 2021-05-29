package com.alif.movieapps.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.data.source.DataRepository
import com.alif.movieapps.utils.DataDummy

class MovieViewModel(private val movieDataRepository: DataRepository) : ViewModel() {

    fun getMovie(): LiveData<List<DataEntity>> = movieDataRepository.getAllMovies()

    fun getDummyMovie() : ArrayList<DataEntity> = DataDummy.getDummyMovie()
}