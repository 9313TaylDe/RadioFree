package com.example.radiofree.app.connection

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiConection {
    val URL_BASE = "https://de1.api.radio-browser.info/json/"
    val api = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(
        ApiResponde::class.java
    )
}