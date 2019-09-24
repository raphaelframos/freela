package com.powellapps.freela.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Group(var name: String) {

    @PrimaryKey(autoGenerate = true)
    var id = 0
}