package com.alif.movieapps.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alif.movieapps.data.entity.DataEntity

@Database(
    entities = [DataEntity::class],
    version = 1,
    exportSchema = false)
abstract class EntityDatabase : RoomDatabase() {
    abstract fun entityDao(): EntityDao

    companion object {
        @Volatile
        private var INSTANCE:  EntityDatabase? = null

        fun getInstance(context: Context): EntityDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    EntityDatabase::class.java,
                    "Entities.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }

}