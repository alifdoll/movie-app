package com.alif.movieapps.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataEntity(
    var id: String,
    var title: String,
    var overview: String,
    var posterPath: String,
    var type: String,
    var favorite: Boolean = false
): Parcelable
