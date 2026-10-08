package com.example.radiofree.app.connection

import com.example.radiofree.app.data.classes.CodecsCountrysCode
import com.example.radiofree.app.data.classes.Languages
import com.example.radiofree.app.data.classes.RadioStation
import com.example.radiofree.app.data.classes.State
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiResponde {

    @GET("json/stations/byuuid/{searchterm}")
    suspend fun getStationById(
        @Path("searchterm") searchTerm: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<RadioStation>

    @GET("json/stations/byname/{searchterm}")
    suspend fun getByName(
        @Path("searchterm") searchTerm: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<RadioStation>

    @GET("json/stations/bynameexact/{searchterm}")
    suspend fun getByNameExact(
        @Path("searchterm") searchTerm: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<RadioStation>

    @GET("json/stations/bycodec/{searchterm}")
    suspend fun getByCodec(
        @Path("searchterm") searchTerm: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<RadioStation>

    @GET("json/stations/bycodecexact/{searchterm}")
    suspend fun getByCodecExact(
        @Path("searchterm") searchTerm: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<RadioStation>

    @GET("json/stations/bycountry/{searchterm}")
    suspend fun getByCountry(
        @Path("searchterm") searchTerm: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<RadioStation>

    @GET("json/stations/bycountryexact/{searchterm}")
    suspend fun getByCountryExact(
        @Path("searchterm") searchTerm: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<RadioStation>

    @GET("json/stations/bycountrycodeexact/{searchterm}")
    suspend fun getByCountryCodeExact(
        @Path("searchterm") searchTerm: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<RadioStation>

    @GET("json/stations/bystate/{searchterm}")
    suspend fun getByState(
        @Path("searchterm") searchTerm: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<RadioStation>

    @GET("json/stations/bystateexact/{searchterm}")
    suspend fun getByStateExact(
        @Path("searchterm") searchTerm: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<RadioStation>

    @GET("json/stations/bylanguage/{searchterm}")
    suspend fun getByLanguage(
        @Path("searchterm") searchTerm: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<RadioStation>

    @GET("json/stations/bylanguageexact/{searchterm}")
    suspend fun getByLanguageExact(
        @Path("searchterm") searchTerm: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<RadioStation>

    @GET("json/stations/bytag/{searchterm}")
    suspend fun getByTag(
        @Path("searchterm") searchTerm: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<RadioStation>

    @GET("json/stations/bytagexact/{searchterm}")
    suspend fun getByTagExact(
        @Path("searchterm") searchTerm: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = false,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<RadioStation>

    @GET("json/stations")
    suspend fun getAllStations(
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = true,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<RadioStation>

    @GET("json/codecs")
    suspend fun getByCodecs(): List<CodecsCountrysCode>

    @GET("json/codecs/{filter}")
    suspend fun getCodecsFilter(
        @Path("filter") filter: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = true,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<CodecsCountrysCode>

    @GET("json/countries")
    suspend fun getByCountries(): List<CodecsCountrysCode>

    @GET("json/countries/{filter}")
    suspend fun getCountriesFilter(
        @Path("filter") filter: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = true,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<CodecsCountrysCode>

    @GET("json/states")
    suspend fun getAllStates(): List<com.example.radiofree.app.data.classes.State>

    @GET("json/states/{filter}")
    suspend fun getStateByFilter(
        @Path("filter") filter: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = true,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<com.example.radiofree.app.data.classes.State>

    @GET("json/states/{country}/{filter}")
    suspend fun getStateByCountryFilter(
        @Path("country") country: String,
        @Path("filter") filter: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = true,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<State>

    @GET("json/languages")
    suspend fun getByLanguages(
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<Languages>
    @GET("json/languages/{filter}")
    suspend fun getByLanguageFilter(
        @Path("filter") filter: String,
        @Query("order") order: String = "name",
        @Query("reverse") reverse: Boolean = false,
        @Query("hidebroken") hideBroken: Boolean = true,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 100
    ): List<Languages>
}
