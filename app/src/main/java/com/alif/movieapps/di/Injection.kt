package com.alif.movieapps.di

import android.content.Context
import com.alif.movieapps.data.source.DataRepository
import com.alif.movieapps.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): DataRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return DataRepository.getInstance(remoteDataSource)
    }
}