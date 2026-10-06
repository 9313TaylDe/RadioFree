package com.example.radiofree.app.connection

import com.example.radiofree.app.data.RadioStation
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiResponde {
    @GET("/json/stations/byuuid/{searchterm}")
    suspend fun getStationById(
        @Path("searchterm") searchtherms: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100000
    ): List<RadioStation>

    @GET("/json/stations/byname/{searchterm")
    suspend fun getByName(
        @Path("searchterm") searchtherms: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100000
    ): List<RadioStation>

    @GET("/json/stations/bynameexact/{searchterm}")
    suspend fun getByNameExact(
        @Path("searchterm") searchtherms: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100000
    ): List<RadioStation>


    @GET("/json/stations/bycodec/{searchterm}")
    suspend fun getByCodec(
        @Path("searchterm") searchtherms: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100000
    ): List<RadioStation>

    @GET("/json/stations/bycodecexact/{searchterm}")
    suspend fun getByCodecExact(
        @Path("searchterm") searchtherms: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100000
    ): List<RadioStation>


}