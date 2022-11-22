package com.vonisak.composeImageList.data.datasource

import com.vonisak.composeImageList.data.model.ResponseImage
import com.vonisak.composeImageList.data.network.ImagesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ImagesDataSource @Inject constructor(private val api: ImagesApi) {

    suspend fun getImages(): List<ResponseImage> = withContext(Dispatchers.IO) { api.getImages() }
}