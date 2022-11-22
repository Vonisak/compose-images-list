package com.vonisak.composeImageList.data.network

import com.vonisak.composeImageList.data.model.ResponseImage
import retrofit2.http.GET

interface ImagesApi {

    @GET("images")
    suspend fun getImages(): List<ResponseImage>
}