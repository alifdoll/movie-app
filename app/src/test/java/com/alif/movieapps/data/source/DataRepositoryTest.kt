package com.alif.movieapps.data.source


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.data.source.local.LocalDataSource
import com.alif.movieapps.data.source.remote.RemoteDataSource
import com.alif.movieapps.data.utils.LiveDataTestUtil
import com.alif.movieapps.data.utils.PagedListUtil
import com.alif.movieapps.utils.AppExecutors
import com.alif.movieapps.utils.DataDummy
import com.alif.movieapps.vo.Resource

import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class DataRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val executors = mock(AppExecutors::class.java)
    private val dataRepository = FakeDataRepository(remote, local, executors)

    private val movieResponse = DataDummy.getDummyMovie()
    private val movieId = movieResponse[0].id

    private val showResponse = DataDummy.getDummyShow()
    private val showId = showResponse[0].id

    private val movie = movieResponse[0]
    private val show = showResponse[0]

    @Test
    fun getAllMovies() {
       val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DataEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        dataRepository.getAllMovies()

        val movies = Resource.success(PagedListUtil.mockPagedList(DataDummy.getDummyMovie()))
        verify(local).getAllMovies()
        assertNotNull(movies.data)
        assertEquals(movieResponse.size.toLong(), movies.data?.size?.toLong())
        assertEquals(movieResponse[0].title, movies.data?.get(0)?.title)
    }

    @Test
    fun getAllShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DataEntity>
        `when`(local.getAllShows()).thenReturn(dataSourceFactory)
        dataRepository.getAllShows()

        val shows = Resource.success(PagedListUtil.mockPagedList(DataDummy.getDummyShow()))
        verify(local).getAllShows()
        assertNotNull(shows.data)
        assertEquals(showResponse.size.toLong(), shows.data?.size?.toLong())
        assertEquals(showResponse[0].title, shows.data?.get(0)?.title)
    }



    @Test
    fun getMovieDetails() {
        val dummy = MutableLiveData<DataEntity>()
        dummy.value = movie
        `when`(local.getEntityById(movieId)).thenReturn(dummy)

        val movieEntity = LiveDataTestUtil.getValue(dataRepository.getMovieDetail(movieId))
        verify(local).getEntityById(movieId)
        assertNotNull(movieEntity)
        assertEquals(movie.title, movieEntity.title)
    }

    @Test
    fun getShowDetails() {
        val dummy = MutableLiveData<DataEntity>()
        dummy.value = show
        `when`(local.getEntityById(showId)).thenReturn(dummy)

        val showEntity = LiveDataTestUtil.getValue(dataRepository.getShowDetail(showId))
        verify(local).getEntityById(showId)
        assertNotNull(showEntity)
        assertEquals(show.title, showEntity.title)
    }

    @Test
    fun getFavoritedMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DataEntity>
        `when`(local.getFavoritedMovies()).thenReturn(dataSourceFactory)
        dataRepository.getFavoritedMovie()

        val dummyFavorite = DataDummy.getDummyMovie()

        for(movies in dummyFavorite) {
            movies.favorite = true
        }
        val favoriteMovies = Resource.success(PagedListUtil.mockPagedList(dummyFavorite))
        verify(local).getFavoritedMovies()
        assertNotNull(favoriteMovies.data)
        assertEquals(movieResponse.size.toLong(), favoriteMovies.data?.size?.toLong())
        assertEquals(movieResponse[0].title, favoriteMovies.data?.get(0)?.title)
        assertTrue(favoriteMovies.data?.get(0)?.favorite!!)
    }

    @Test
    fun getFavoritedShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DataEntity>
        `when`(local.getFavoritedShows()).thenReturn(dataSourceFactory)
        dataRepository.getFavoritedShow()

        val dummyFavorite = DataDummy.getDummyShow()
        for(shows in dummyFavorite) {
            shows.favorite = true
        }
        val favoriteShows = Resource.success(PagedListUtil.mockPagedList(dummyFavorite))
        verify(local).getFavoritedShows()
        assertNotNull(favoriteShows.data)
        assertEquals(showResponse.size.toLong(), favoriteShows.data?.size?.toLong())
        assertEquals(showResponse[0].title, favoriteShows.data?.get(0)?.title)
        assertTrue(favoriteShows.data?.get(0)?.favorite!!)

    }


}