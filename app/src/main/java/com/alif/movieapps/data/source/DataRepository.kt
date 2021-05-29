package com.alif.movieapps.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.data.source.remote.RemoteDataSource
import com.alif.movieapps.data.source.remote.response.EntityItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DataRepository private constructor(private val remoteDataSource: RemoteDataSource) : DataSource {


    companion object {
        @Volatile
        private var instance: DataRepository? = null

        fun getInstance(remoteData: RemoteDataSource): DataRepository =
                instance ?: synchronized(this) {
                    instance ?: DataRepository(remoteData).apply { instance = this }
                }

        private const val POSTER_URL = "https://image.tmdb.org/t/p/original/"
    }

    override fun getAllMovies(): LiveData<List<DataEntity>> {
        val listMovie = MutableLiveData<List<DataEntity>>()

        CoroutineScope(IO).launch {
            remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMovieCallback {
                override fun movieReceived(movieResponse: List<EntityItems>) {
                    val movies = ArrayList<DataEntity>()

                    for(response in movieResponse) {
                        val movie = DataEntity(
                                response.id.toString(),
                                response.title,
                                response.overview,
                                POSTER_URL+response.posterPath,
                                "Movie"
                        )
                        movies.add(movie)
                    }
                    listMovie.postValue(movies)
                }
            })
        }
        return listMovie
    }

    override fun getAllShows(): LiveData<List<DataEntity>> {
        val listShow = MutableLiveData<List<DataEntity>>()

        CoroutineScope(IO).launch {
            remoteDataSource.getAllShows(object : RemoteDataSource.LoadShowCallback {
                override fun showReceived(showResponse: List<EntityItems>) {
                    val list = ArrayList<DataEntity>()

                    for (response in showResponse) {
                        val show = DataEntity(
                                response.id.toString(),
                                response.title,
                                response.overview,
                                POSTER_URL+response.posterPath,
                                "Show"
                        )
                        list.add(show)
                    }
                    listShow.postValue(list)
                }

            })
        }
        return listShow
    }

    override fun getMovieDetail(id: String): LiveData<DataEntity> {
        val movie = MutableLiveData<DataEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getMovieDetail(id, object : RemoteDataSource.LoadDetail{
                override fun detailReceived(detailResponse: EntityItems) {
                    val response = DataEntity(
                            detailResponse.id.toString(),
                            detailResponse.title,
                            detailResponse.overview,
                            POSTER_URL+detailResponse.posterPath,
                            "Movie"
                    )

                    movie.postValue(response)
                }

            })
        }
        return movie
    }

    override fun getShowDetail(id: String): LiveData<DataEntity> {
        val show = MutableLiveData<DataEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getShowDetail(id, object : RemoteDataSource.LoadDetail{
                override fun detailReceived(detailResponse: EntityItems) {
                    val response = DataEntity(
                            detailResponse.id.toString(),
                            detailResponse.title,
                            detailResponse.overview,
                            POSTER_URL+detailResponse.posterPath,
                            "Show"
                    )

                    show.postValue(response)
                }

            })
        }
        return show
    }

}