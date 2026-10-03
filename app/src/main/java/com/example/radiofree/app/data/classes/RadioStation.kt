package com.example.radiofree.app.data.classes

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "RadioStation")
data class RadioStation(

    @SerializedName("changeuuid")
    @PrimaryKey

    val changeUuid: String,

    @SerializedName("stationuuid")
    val stationUuid: String,

    @SerializedName("serveruuid")
    val serverUuid: String,

    val name: String,

    val url: String,

    @SerializedName("url_resolved")
    val urlResolved: String,

    val homepage: String,

    val favicon: String?,

    val tags: String,

    val country: String?,

    @SerializedName("countrycode")
    val countryCode: String,

    @SerializedName("iso_3166_2")
    val iso31662: String?,

    val state: String,

    val language: String,

    @SerializedName("languagecodes")
    val languageCodes: String,

    val votes: Int,

    @SerializedName("lastchangetime")
    val lastChangeTime: String,

    @SerializedName("lastchangetime_iso8601")
    val lastChangeTimeIso8601: String,

    val codec: String,

    val bitrate: Int,

    val hls: Int,

    @SerializedName("lastcheckok")
    val lastCheckOk: Int,

    @SerializedName("lastchecktime")
    val lastCheckTime: String,

    @SerializedName("lastchecktime_iso8601")
    val lastCheckTimeIso8601: String,

    @SerializedName("lastcheckoktime")
    val lastCheckOkTime: String,

    @SerializedName("lastcheckoktime_iso8601")
    val lastCheckOkTimeIso8601: String,

    @SerializedName("lastlocalchecktime")
    val lastLocalCheckTime: String?,

    @SerializedName("lastlocalchecktime_iso8601")
    val lastLocalCheckTimeIso8601: String?,

    @SerializedName("clicktimestamp")
    val clickTimestamp: String,

    @SerializedName("clicktimestamp_iso8601")
    val clickTimestampIso8601: String?,

    @SerializedName("clickcount")
    val clickCount: Int,

    @SerializedName("clicktrend")
    val clickTrend: Int,

    @SerializedName("ssl_error")
    val sslError: Int,

    @SerializedName("geo_lat")
    val geoLat: Float?,

    @SerializedName("geo_long")
    val geoLong: Float?,

    @SerializedName("has_extended_info")
    val hasExtendedInfo: Boolean
)