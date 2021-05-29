package com.alif.movieapps.ui.show

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.data.source.DataRepository
import com.alif.movieapps.utils.DataDummy

class ShowViewModel(private val showDataRepository: DataRepository): ViewModel() {

    fun getShow(): LiveData<List<DataEntity>> = showDataRepository.getAllShows()

    fun getDummyShow() : ArrayList<DataEntity> = DataDummy.getDummyShow()
}