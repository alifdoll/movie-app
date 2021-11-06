package com.alif.movieapps.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.data.source.local.room.EntityDao

class LocalDataSource private constructor(private val mEntityDao: EntityDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(entityDao: EntityDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(entityDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, DataEntity> = mEntityDao.getAllMovies()

    fun getAllShows(): DataSource.Factory<Int, DataEntity> = mEntityDao.getAllShows()

    fun getEntityById(id: Int): LiveData<DataEntity> = mEntityDao.getEntityById(id)

    fun getFavoritedMovies(): DataSource.Factory<Int, DataEntity> = mEntityDao.getFavoriteMovie()

    fun getFavoritedShows(): DataSource.Factory<Int, DataEntity> = mEntityDao.getFavoriteShow()

    fun insertEntities(entities: List<DataEntity>) = mEntityDao.insertEntities(entities)

    fun setEntityFavorite(entity: DataEntity) {
        entity.favorite = true
        mEntityDao.updateEntity(entity)
    }

    fun setEntityUnfavorite(entity: DataEntity) {
        entity.favorite = false
        mEntityDao.updateEntity(entity)
    }
}