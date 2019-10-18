package com.powellapps.freela.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Freela {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var name = ""

    fun addName(name: String): Freela {
        this.name = name
        return this
    }
}