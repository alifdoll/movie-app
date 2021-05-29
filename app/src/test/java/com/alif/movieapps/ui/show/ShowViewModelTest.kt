package com.alif.movieapps.ui.show

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.data.source.DataRepository
import com.alif.movieapps.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ShowViewModelTest {

    private lateinit var viewModel: ShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observer: Observer<List<DataEntity>>

    @Before
    fun setUp() {
        viewModel = ShowViewModel(dataRepository)
    }

    @Test
    fun getShow() {
        val show = MutableLiveData<List<DataEntity>>()
        val dummy = DataDummy.getDummyShow()
        show.value = dummy

        Mockito.`when`(dataRepository.getAllShows()).thenReturn(show)

        val shows = viewModel.getShow().value
        Mockito.verify<DataRepository>(dataRepository).getAllShows()

        assertNotNull(shows)
        assertEquals(10, shows?.size)

        viewModel.getShow().observeForever(observer)
        verify(observer).onChanged(dummy)
    }
}