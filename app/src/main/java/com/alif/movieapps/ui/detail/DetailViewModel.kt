package com.alif.movieapps.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.data.source.DataRepository
import com.alif.movieapps.utils.DataDummy

class DetailViewModel(private val detailDataRepository: DataRepository) : ViewModel() {

    private lateinit var id: String

    fun setSelectedId(id: String) {
        this.id = id
    }

    fun getMovieDetail(id: String): LiveData<DataEntity> = detailDataRepository.getMovieDetail(id)

    fun getShowDetail(id: String): LiveData<DataEntity> = detailDataRepository.getShowDetail(id)

    fun getDummyMovieDetail(): DataEntity {
        lateinit var movie: DataEntity
        val movies = DataDummy.getDummyMovie()
        for(movieEntity in movies) {
            if(movieEntity.id == id) {
                movie = movieEntity
            }
        }

        return movie
    }

    fun getDummyShowDetail(): DataEntity {
        lateinit var show: DataEntity
        val shows = DataDummy.getDummyShow()
        for(showEntity in shows) {
            if(showEntity.id == id) {
                show = showEntity
            }
        }

        return show
    }
}