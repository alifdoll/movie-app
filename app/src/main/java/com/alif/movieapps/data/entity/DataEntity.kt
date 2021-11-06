package com.alif.movieapps.data.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "entities")
@Parcelize
data class DataEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo
    var id: Int,

    @NonNull
    @ColumnInfo
    var title: String,

    @NonNull
    @ColumnInfo
    var overview: String,

    @NonNull
    @ColumnInfo
    var posterPath: String,

    @NonNull
    @ColumnInfo
    var type: String,

    @NonNull
    @ColumnInfo
    var favorite: Boolean = false
): Parcelable
