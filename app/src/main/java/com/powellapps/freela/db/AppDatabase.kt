package com.powellapps.freela.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.powellapps.freela.dao.FunctionalityDao
import com.powellapps.freela.model.Functionality

@Database(entities = [Functionality::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun functionalityDao() : FunctionalityDao
}