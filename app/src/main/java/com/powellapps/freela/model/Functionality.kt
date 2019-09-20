package com.powellapps.freela.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Functionality constructor(var name: String, var amountOfHours: Double) {

    @PrimaryKey(autoGenerate = true)
    var id = 0
    var active = false

}