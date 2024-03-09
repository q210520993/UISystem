package com.skillw.uisystem.util

import com.google.gson.GsonBuilder

object Gson {

    @JvmStatic
    fun toJson(`object`: Any?): String {
        val builder = GsonBuilder()
        val gson = builder.create()
        return gson.toJson(`object`)
    }


}