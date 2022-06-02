package com.itigevc.walletmind.data.remote.model.weather

data class Sys (

    @SerializedName("country" ) var country : String? = null,
    @SerializedName("sunrise" ) var sunrise : Int?    = null,
    @SerializedName("sunset"  ) var sunset  : Int?    = null

)