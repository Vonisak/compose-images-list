package com.vonisak.composeImageList.data.model

import com.google.gson.annotations.SerializedName

data class ResponseImage(
    @SerializedName("id") val id: Int,
    @SerializedName("url") val url: String
)