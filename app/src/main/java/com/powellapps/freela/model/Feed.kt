package com.powellapps.freela.model


class Feed {

    var freela: Freela = Freela()
    var userName = ""
    var userPhoto = ""

    fun toMap(): HashMap<String, Any> {
        val map : HashMap<String, Any> = HashMap()
        map.put("userName", userName)
        map.put("userPhoto", userPhoto)
        map.put("freela", freela.toMap())
        return map

    }
}