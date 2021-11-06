package com.alif.movieapps.ui.entity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.data.source.DataRepository
import com.alif.movieapps.vo.Resource

class EntityViewModel(private val entityDataRepository: DataRepository) : ViewModel() {

    fun getMovie(): LiveData<Resource<PagedList<DataEntity>>> = entityDataRepository.getAllMovies()

    fun getShow(): LiveData<Resource<PagedList<DataEntity>>> = entityDataRepository.getAllShows()

    fun getFavoritedMovie(): LiveData<PagedList<DataEntity>> = entityDataRepository.getFavoritedMovie()

    fun getFavoritedShow(): LiveData<PagedList<DataEntity>> = entityDataRepository.getFavoritedShow()

    fun setFavorite(entity: DataEntity) {
        entityDataRepository.setFavorite(entity)
    }

    fun setUnfavorite(entity: DataEntity) {
        entityDataRepository.setUnfavorite(entity)
    }
}