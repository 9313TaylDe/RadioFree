
package com.example.radiofree.app.data.classes

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "RadioStation")
data class RadioStation(

    @PrimaryKey
    @SerializedName("stationuuid")
    val stationUuid: String,

    @SerializedName("changeuuid")
    val changeUuid: String? = null,

    @SerializedName("serveruuid")
    val serverUuid: String? = null,

    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("url_resolved")
    val urlResolved: String? = null,

    @SerializedName("homepage")
    val homepage: String? = null,

    @SerializedName("favicon")
    val favicon: String? = null,

    @SerializedName("tags")
    val tags: String? = null,

    @SerializedName("country")
    val country: String? = null,

    @SerializedName("countrycode")
    val countryCode: String? = null,

    @SerializedName("iso_3166_2")
    val iso31662: String? = null,

    @SerializedName("state")
    val state: String? = null,

    @SerializedName("language")
    val language: String? = null,

    @SerializedName("languagecodes")
    val languageCodes: String? = null,

    @SerializedName("votes")
    val votes: Int = 0,

    @SerializedName("lastchangetime")
    val lastChangeTime: String? = null,

    @SerializedName("lastchangetime_iso8601")
    val lastChangeTimeIso8601: String? = null,

    @SerializedName("codec")
    val codec: String? = null,

    @SerializedName("bitrate")
    val bitrate: Int = 0,

    @SerializedName("hls")
    val hls: Int = 0,

    @SerializedName("lastcheckok")
    val lastCheckOk: Int = 0,

    @SerializedName("lastchecktime")
    val lastCheckTime: String? = null,

    @SerializedName("lastchecktime_iso8601")
    val lastCheckTimeIso8601: String? = null,

    @SerializedName("lastcheckoktime")
    val lastCheckOkTime: String? = null,

    @SerializedName("lastcheckoktime_iso8601")
    val lastCheckOkTimeIso8601: String? = null,

    @SerializedName("lastlocalchecktime")
    val lastLocalCheckTime: String? = null,

    @SerializedName("lastlocalchecktime_iso8601")
    val lastLocalCheckTimeIso8601: String? = null,

    @SerializedName("clicktimestamp")
    val clickTimestamp: String? = null,

    @SerializedName("clicktimestamp_iso8601")
    val clickTimestampIso8601: String? = null,

    @SerializedName("clickcount")
    val clickCount: Int = 0,

    @SerializedName("clicktrend")
    val clickTrend: Int = 0,

    @SerializedName("ssl_error")
    val sslError: Int = 0,

    @SerializedName("geo_lat")
    val geoLat: Double? = null,

    @SerializedName("geo_long")
    val geoLong: Double? = null,

    @SerializedName("has_extended_info")
    val hasExtendedInfo: Boolean? = null
)
