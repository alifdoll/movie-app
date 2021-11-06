package com.alif.movieapps.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EntityItems(

        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName(value = "title", alternate = ["name"])
        val title: String,

        @field:SerializedName("overview")
        val overview: String,

        @field:SerializedName("poster_path")
        val posterPath: String,

        val favorite: Boolean = false
): Parcelable