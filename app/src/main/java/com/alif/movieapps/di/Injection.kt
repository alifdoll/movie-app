package com.alif.movieapps.di

import android.content.Context
import com.alif.movieapps.data.source.DataRepository
import com.alif.movieapps.data.source.local.LocalDataSource
import com.alif.movieapps.data.source.local.room.EntityDatabase
import com.alif.movieapps.data.source.remote.RemoteDataSource
import com.alif.movieapps.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): DataRepository {
        val database = EntityDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.entityDao())
        val appExecutors = AppExecutors()


        return DataRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}