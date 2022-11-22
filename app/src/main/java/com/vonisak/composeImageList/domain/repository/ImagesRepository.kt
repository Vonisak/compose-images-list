package com.vonisak.composeImageList.domain.repository

import com.vonisak.composeImageList.domain.entity.Image

interface ImagesRepository {

    suspend fun getImages(): List<Image>
}