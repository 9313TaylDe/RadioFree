package com.example.radiofree.app.data.classes

import com.google.gson.annotations.SerializedName

data class Languages(
    val name:String,
    @SerializedName("iso_639")
    val iso_639:String,
    val stationcount:String
)
