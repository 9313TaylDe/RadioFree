package com.example.radiofree.app.data.classes

import com.google.gson.annotations.SerializedName

data class StationCheck(

    @SerializedName("stationuuid")
    val stationUuid: String,

    @SerializedName("checkuuid")
    val checkUuid: String,

    val source: String,

    val codec: String,

    val bitrate: Int,

    val hls: Int,

    val ok: Int,

    @SerializedName("timestamp_iso8601")
    val timestampIso8601: String,

    val timestamp: String,

    @SerializedName("urlcache")
    val urlCache: String,

    @SerializedName("metainfo_overrides_database")
    val metainfoOverridesDatabase: Int,

    val public: Int?,

    val name: String?,

    val description: String?,

    val tags: String?,

    @SerializedName("countrycode")
    val countryCode: String?,

    val homepage: String?,

    val favicon: String?,

    val loadbalancer: String?,

    @SerializedName("do_not_index")
    val doNotIndex: Int?,

    @SerializedName("countrysubdivisioncode")
    val countrySubdivisionCode: String?,

    @SerializedName("server_software")
    val serverSoftware: String?,

    val sampling: Int?,

    @SerializedName("timing_ms")
    val timingMs: Int?,

    @SerializedName("languagecodes")
    val languageCodes: String?,

    @SerializedName("ssl_error")
    val sslError: Int?,

    @SerializedName("geo_lat")
    val geoLat: Float?,

    @SerializedName("geo_long")
    val geoLong: Float?
)