package com.powellapps.freela.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.Exception

@Entity
class Freela {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var name = ""
    var publicId = ""
    var profession = ""
    var language = ""
    var hourValue = 0.0

    fun addName(name: String): Freela {
        this.name = name
        return this
    }

    fun addPublicId(id: String): Freela {
        this.publicId = id
        return this
    }
    fun addProfession(profession: String): Freela {
        this.profession = profession
        return this
    }
    fun addLanguage(language: String): Freela {
        this.language = language
        return this
    }
    fun addHourValue(value: Double): Freela {
        this.hourValue = value
        return this
    }

    fun addHourValue(value: String): Freela {

        try {
            this.hourValue = value.toDouble()
        }catch (e : Exception){
            this.hourValue = 0.0
        }

        return this
    }
}