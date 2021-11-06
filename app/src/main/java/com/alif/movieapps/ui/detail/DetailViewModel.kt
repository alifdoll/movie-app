package com.alif.movieapps.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.data.source.DataRepository
import com.alif.movieapps.utils.DataDummy
import com.alif.movieapps.vo.Resource

class DetailViewModel(private val detailDataRepository: DataRepository) : ViewModel() {

    fun getMovieDetail(id: Int): LiveData<DataEntity> = detailDataRepository.getMovieDetail(id)

    fun getShowDetail(id: Int): LiveData<DataEntity> = detailDataRepository.getShowDetail(id)

}