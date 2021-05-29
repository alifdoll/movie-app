package com.alif.movieapps.data.source

import androidx.lifecycle.LiveData
import com.alif.movieapps.data.entity.DataEntity

interface DataSource {

    fun getAllMovies(): LiveData<List<DataEntity>>

    fun getAllShows(): LiveData<List<DataEntity>>

    fun getMovieDetail(id: String): LiveData<DataEntity>

    fun getShowDetail(id: String): LiveData<DataEntity>
}