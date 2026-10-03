package com.example.radiofree.app.data

import com.google.gson.annotations.SerializedName

data class StationCheckSteps(

    @SerializedName("stepuuid")
    val stepUuid: String,

    @SerializedName("parent_stepuuid")
    val parentStepUuid: String,

    @SerializedName("checkuuid")
    val checkUuid: String,

    @SerializedName("stationuuid")
    val stationUuid: String,

    val url: String,

    @SerializedName("urltype")
    val urlType: String,

    val error: String,

    @SerializedName("creation_iso8601")
    val creationIso8601: String
)