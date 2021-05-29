package com.alif.movieapps.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EntityItems(

        @field:SerializedName("overview")
        val overview: String,

        @field:SerializedName(value = "title", alternate = ["name"])
        val title: String,

        @field:SerializedName("poster_path")
        val posterPath: String,

        @field:SerializedName("id")
        val id: Int,

        val favorite: Boolean = false
): Parcelable