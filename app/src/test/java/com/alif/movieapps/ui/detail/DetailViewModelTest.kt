package com.alif.movieapps.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.data.source.DataRepository
import com.alif.movieapps.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.getDummyMovie()[0]
    private val movieId = dummyMovie.id

    private val dummyShow = DataDummy.getDummyShow()[0]
    private val showId = dummyShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var dataObserver: Observer<DataEntity>


    @Before
    fun setUp() {
        viewModel = DetailViewModel(dataRepository)
        viewModel.setSelectedId(movieId)
    }


    @Test
    fun getMovie() {
        val movie = MutableLiveData<DataEntity>()
        movie.value = dummyMovie

        `when`(dataRepository.getMovieDetail(movieId)).thenReturn(movie)
        val movieEntity = viewModel.getMovieDetail(movieId).value as DataEntity
        assertEquals("Movie", movieEntity.type)

        assertNotNull(movieEntity)

        assertNotNull(movieEntity.id)
        assertEquals(dummyMovie.id, movieEntity.id  )

        assertNotNull(movieEntity.title)
        assertEquals(dummyMovie.title, movieEntity.title)

        assertNotNull(movieEntity.posterPath)
        assertEquals(dummyMovie.posterPath, movieEntity.posterPath)

        assertNotNull(movieEntity.overview)
        assertEquals(dummyMovie.overview, movieEntity.overview)

        assertFalse(movieEntity.favorite)
        assertEquals(dummyMovie.favorite, movieEntity.favorite)

        assertEquals(dummyMovie.type, "Movie")

        viewModel.getMovieDetail(movieId).observeForever(dataObserver)
        verify(dataObserver).onChanged(dummyMovie)

    }

    @Test
    fun getShow() {
        val show = MutableLiveData<DataEntity>()
        show.value = dummyShow

        `when`(dataRepository.getShowDetail(showId)).thenReturn(show)
        val showEntity = viewModel.getShowDetail(showId).value as DataEntity
        assertEquals("Show", showEntity.type)

        assertNotNull(showEntity)

        assertNotNull(showEntity.id)
        assertEquals(dummyShow.id, showEntity.id  )

        assertNotNull(showEntity.title)
        assertEquals(dummyShow.title, showEntity.title)

        assertNotNull(showEntity.posterPath)
        assertEquals(dummyShow.posterPath, showEntity.posterPath)

        assertNotNull(showEntity.overview)
        assertEquals(dummyShow.overview, showEntity.overview)

        assertFalse(showEntity.favorite)
        assertEquals(dummyShow.favorite, showEntity.favorite)

        assertEquals(dummyShow.type, "Show")

        viewModel.getShowDetail(showId).observeForever(dataObserver)
        verify(dataObserver).onChanged(dummyShow)
    }
}