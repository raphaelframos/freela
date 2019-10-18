package com.powellapps.freela.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.powellapps.freela.model.Freela

@Dao
interface FreelaDao {

    @Insert
    fun add(vararg freela: Freela)

    @Query("SELECT * FROM Freela")
    fun list() : List<Freela>
}