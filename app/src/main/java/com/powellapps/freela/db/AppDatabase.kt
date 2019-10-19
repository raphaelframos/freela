package com.powellapps.freela.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.powellapps.freela.dao.FreelaDao
import com.powellapps.freela.dao.FunctionalityDao
import com.powellapps.freela.model.Freela
import com.powellapps.freela.model.Functionality

@Database(entities = [Functionality::class, Freela::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun functionalityDao() : FunctionalityDao
    abstract fun freelaDao(): FreelaDao

    object Database{
        @Volatile
        private lateinit var database: AppDatabase

        fun instance(context: Context) : AppDatabase {
            synchronized(this){
                if(::database.isInitialized) return database
                database = Room.databaseBuilder(context, AppDatabase::class.java, "freela.db").build()
                return database
            }
        }
    }

}