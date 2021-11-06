package com.alif.movieapps.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alif.movieapps.BuildConfig
import com.alif.movieapps.data.source.remote.api.ApiConfig
import com.alif.movieapps.data.source.remote.response.EntityItems
import com.alif.movieapps.data.source.remote.vo.ApiResponse
import com.alif.movieapps.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.await

class RemoteDataSource {


    private val API_KEY = BuildConfig.API_KEY
    private val TAG = "REMOTE DATA SOURCE"

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource().apply { instance = this }
                }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<EntityItems>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<EntityItems>>>()
        CoroutineScope(IO).launch {
            try {
                val response = ApiConfig.getApiServiceMovie().getMovie(API_KEY).await()
                resultMovie.postValue(ApiResponse.success(response.results))
            } catch (error: Exception) {
                error.printStackTrace()
                resultMovie.postValue(ApiResponse.error(error.message.toString(), mutableListOf()))
            }
        }
        EspressoIdlingResource.decrement()
        return resultMovie
    }

    fun getAllShows(): LiveData<ApiResponse<List<EntityItems>>> {
        EspressoIdlingResource.increment()
        val resultShow = MutableLiveData<ApiResponse<List<EntityItems>>>()
        CoroutineScope(IO).launch {
            try {
                val response = ApiConfig.getApiServiceShow().getShow(API_KEY).await()
                resultShow.postValue(ApiResponse.success(response.results))
            } catch (error: Exception) {
                error.printStackTrace()
                resultShow.postValue(ApiResponse.error(error.message.toString(), mutableListOf()))
            }
        }
        EspressoIdlingResource.decrement()
        return resultShow
    }
}
