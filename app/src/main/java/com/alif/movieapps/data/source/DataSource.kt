package com.alif.movieapps.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.vo.Resource

interface DataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<DataEntity>>>

    fun getAllShows(): LiveData<Resource<PagedList<DataEntity>>>

    fun getMovieDetail(id: Int): LiveData<DataEntity>

    fun getShowDetail(id: Int): LiveData<DataEntity>

    fun setFavorite(entity: DataEntity)

    fun setUnfavorite(entity: DataEntity)

    fun getFavoritedMovie(): LiveData<PagedList<DataEntity>>

    fun getFavoritedShow(): LiveData<PagedList<DataEntity>>


}