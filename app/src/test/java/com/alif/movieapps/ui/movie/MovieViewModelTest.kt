package com.alif.movieapps.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.data.source.DataRepository
import com.alif.movieapps.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observer: Observer<List<DataEntity>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(dataRepository)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<List<DataEntity>>()
        val dummy = DataDummy.getDummyMovie()
        movie.value = dummy

       `when`(dataRepository.getAllMovies()).thenReturn(movie)
        val movieList = viewModel.getMovie().value
        verify(dataRepository).getAllMovies()

        assertNotNull(movieList)
        assertEquals(10, movieList?.size)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummy)
    }
}