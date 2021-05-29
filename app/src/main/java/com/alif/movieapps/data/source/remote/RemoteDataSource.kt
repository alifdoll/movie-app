package com.alif.movieapps.data.source.remote

import com.alif.movieapps.BuildConfig
import com.alif.movieapps.data.source.remote.api.ApiConfig
import com.alif.movieapps.data.source.remote.response.EntityItems
import com.alif.movieapps.utils.EspressoIdlingResource
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

    suspend fun getAllMovies(callBack: LoadMovieCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiServiceMovie().getMovie(API_KEY).await().results.let { listMovie ->
            callBack.movieReceived(listMovie)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getAllShows(callBack: LoadShowCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiServiceShow().getShow(API_KEY).await().results.let { listShow ->
            callBack.showReceived(listShow)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getMovieDetail(id: String, callback: LoadDetail) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiServiceMovie().getMovieDetail(id,API_KEY).await().let { movie ->
            callback.detailReceived(movie)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getShowDetail(id: String, callback: LoadDetail) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiServiceShow().getShowDetail(id, API_KEY).await().let { show ->
            callback.detailReceived(show)
            EspressoIdlingResource.decrement()
        }
    }

    interface LoadShowCallback {
        fun showReceived(showResponse: List<EntityItems>)
    }

    interface LoadMovieCallback {
        fun movieReceived(movieResponse: List<EntityItems>)
    }

    interface LoadDetail {
        fun detailReceived(detailResponse: EntityItems)
    }


}
