

package com.example.radiofree.app.connection

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConection {

    private const val URL_BASE =
        "https://de1.api.radio-browser.info/"

    val api: ApiResponde by lazy {
        Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiResponde::class.java)
    }
}