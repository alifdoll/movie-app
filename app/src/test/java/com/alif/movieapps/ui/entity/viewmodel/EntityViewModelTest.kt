package com.alif.movieapps.ui.entity.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.data.source.DataRepository
import com.alif.movieapps.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class EntityViewModelTest{
    private lateinit var viewModel: EntityViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observerResource: Observer<Resource<PagedList<DataEntity>>>

    @Mock
    private lateinit var observer: Observer<PagedList<DataEntity>>

    @Mock
    private lateinit var entityPagedList: PagedList<DataEntity>

    @Before
    fun setUp() {
        viewModel = EntityViewModel(dataRepository)
    }

    @Test
    fun getMovies() {
        val dummy = Resource.success(entityPagedList)
        `when`(dummy.data?.size).thenReturn(5)
        val movie = MutableLiveData<Resource<PagedList<DataEntity>>>()
        movie.value = dummy

        `when`(dataRepository.getAllMovies()).thenReturn(movie)
        val movies = viewModel.getMovie().value?.data
        verify(dataRepository).getAllMovies()

        assertNotNull(movies)
        assertEquals(5, movies?.size)

        viewModel.getMovie().observeForever(observerResource)
        verify(observerResource).onChanged(dummy)
    }

    @Test
    fun getShows() {
        val dummy = Resource.success(entityPagedList)
        `when`(dummy.data?.size).thenReturn(5)
        val show = MutableLiveData<Resource<PagedList<DataEntity>>>()
        show.value = dummy

        `when`(dataRepository.getAllShows()).thenReturn(show)
        val shows = viewModel.getShow().value?.data
        verify(dataRepository).getAllShows()

        assertNotNull(shows)
        assertEquals(5, shows?.size)

        viewModel.getShow().observeForever(observerResource)
        verify(observerResource).onChanged(dummy)
    }

    @Test
    fun getFavoriteMovie() {
        val dummy = entityPagedList
        `when`(dummy.size).thenReturn(5)
        val movie = MutableLiveData<PagedList<DataEntity>>()
        movie.value = dummy

        `when`(dataRepository.getFavoritedMovie()).thenReturn(movie)
        val movies = viewModel.getFavoritedMovie().value
        verify(dataRepository).getFavoritedMovie()

        assertNotNull(movies)
        assertEquals(5, movies?.size)

        viewModel.getFavoritedMovie().observeForever(observer)
        verify(observer).onChanged(dummy)

    }

    @Test
    fun getFavoriteShow() {
        val dummy = entityPagedList
        `when`(dummy.size).thenReturn(5)
        val show = MutableLiveData<PagedList<DataEntity>>()
        show.value = dummy

        `when`(dataRepository.getFavoritedShow()).thenReturn(show)
        val shows = viewModel.getFavoritedShow().value
        verify(dataRepository).getFavoritedShow()

        assertNotNull(shows)
        assertEquals(5, shows?.size)

        viewModel.getFavoritedShow().observeForever(observer)
        verify(observer).onChanged(dummy)
    }
}