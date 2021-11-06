package com.alif.movieapps.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.alif.movieapps.data.entity.DataEntity

@Dao
interface EntityDao {

    @Query("SELECT * FROM entities WHERE type = 'Movie'")
    fun getAllMovies(): DataSource.Factory<Int, DataEntity>

    @Query("SELECT * FROM entities WHERE type = 'Show'")
    fun getAllShows(): DataSource.Factory<Int, DataEntity>

    @Query("SELECT * FROM entities WHERE type = 'Movie' AND favorite = 1")
    fun getFavoriteMovie(): DataSource.Factory<Int, DataEntity>

    @Query("SELECT * FROM entities WHERE type = 'Show' AND favorite = 1")
    fun getFavoriteShow(): DataSource.Factory<Int, DataEntity>

    @Transaction
    @Query("SELECT * FROM entities WHERE id = :id")
    fun getEntityById(id: Int): LiveData<DataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEntities(entities: List<DataEntity>)

    @Update
    fun updateEntity(entity: DataEntity)

    @Delete
    fun deleteEntity(entity: DataEntity)
}