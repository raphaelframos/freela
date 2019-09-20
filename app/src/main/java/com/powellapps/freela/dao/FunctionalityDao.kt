package com.powellapps.freela.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.powellapps.freela.model.Functionality

@Dao
interface FunctionalityDao {

    @Query("SELECT * FROM Functionality")
    fun findAll(): List<Functionality>

    @Insert
    fun save(vararg function: Functionality)
}