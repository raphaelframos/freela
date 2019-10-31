package com.powellapps.freela.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.Exception
import java.util.*

@Entity
class Freela {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var name = ""
    var publicId = ""
    var profession = ""
    var language = ""
    var totalTime = 0
    var hourValue = 0.0
    var date : Long = 0

    fun isPrivate() : Boolean {
        return publicId.isEmpty()
    }

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

    fun toMap(): HashMap<String, Any> {
        val map : HashMap<String, Any> = HashMap()
        map.put("name", name)
        map.put("hourValue", hourValue)
        map.put("profession", profession)
        map.put("language", language)
        map.put("publicId", publicId)
        map.put("date", date)
        return map

    }
}