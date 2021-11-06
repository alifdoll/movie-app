package com.alif.movieapps.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.data.source.local.LocalDataSource
import com.alif.movieapps.data.source.remote.RemoteDataSource
import com.alif.movieapps.data.source.remote.response.EntityItems
import com.alif.movieapps.data.source.remote.vo.ApiResponse
import com.alif.movieapps.utils.AppExecutors
import com.alif.movieapps.vo.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DataRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors)
    : DataSource {


    companion object {
        @Volatile
        private var instance: DataRepository? = null

        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): DataRepository =
                instance ?: synchronized(this) {
                    instance ?: DataRepository(remoteData, localData, appExecutors).apply {
                        instance = this
                    }
                }

        private const val POSTER_URL = "https://image.tmdb.org/t/p/original/"
    }

    override fun getAllMovies(): LiveData<Resource<PagedList<DataEntity>>> {
        return object : NetworkBoundResource<PagedList<DataEntity>, List<EntityItems>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<DataEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<DataEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<EntityItems>>> {
                return remoteDataSource.getAllMovies()
            }

            override fun saveCallResult(data: List<EntityItems>) {
                val movieList = ArrayList<DataEntity>()
                for(item in data) {
                    val movie = DataEntity(
                        item.id,
                        item.title,
                        item.overview,
                        POSTER_URL+item.posterPath,
                        "Movie"
                    )
                    movieList.add(movie)
                    Log.d("Data Repository:POSTER", item.posterPath)
                }
                localDataSource.insertEntities(movieList)
            }

        }.asLiveData()
    }

    override fun getAllShows(): LiveData<Resource<PagedList<DataEntity>>> {
        return object : NetworkBoundResource<PagedList<DataEntity>, List<EntityItems>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<DataEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<DataEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<EntityItems>>> {
                return remoteDataSource.getAllShows()
            }

            override fun saveCallResult(data: List<EntityItems>) {
                val showList = ArrayList<DataEntity>()
                for(item in data) {
                    val show = DataEntity(
                        item.id,
                        item.title,
                        item.overview,
                        POSTER_URL+item.posterPath,
                        "Show"
                    )
                    showList.add(show)
                    Log.d("Data Repository:POSTER", item.posterPath)
                }
                localDataSource.insertEntities(showList)
            }

        }.asLiveData()
    }

    override fun getMovieDetail(id: Int): LiveData<DataEntity> {
        return localDataSource.getEntityById(id)
    }

    override fun getShowDetail(id: Int): LiveData<DataEntity> {
       return localDataSource.getEntityById(id)
    }

    override fun setFavorite(entity: DataEntity) {
        appExecutors.diskIO().execute {
            localDataSource.setEntityFavorite(entity)
        }
    }

    override fun setUnfavorite(entity: DataEntity) {
        appExecutors.diskIO().execute {
            localDataSource.setEntityUnfavorite(entity)
        }
    }

    override fun getFavoritedMovie(): LiveData<PagedList<DataEntity>> {
        val config= PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(5)
            .setPageSize(5)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoritedMovies(), config).build()
    }

    override fun getFavoritedShow(): LiveData<PagedList<DataEntity>> {
        val config= PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(5)
            .setPageSize(5)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoritedShows(), config).build()
    }

}