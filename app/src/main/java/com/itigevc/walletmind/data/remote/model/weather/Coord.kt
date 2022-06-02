package com.itigevc.walletmind.data.remote.model.weather

data class Coord (

    @SerializedName("lon" ) var lon : Double? = null,
    @SerializedName("lat" ) var lat : Double? = null

)