package com.vonisak.composeImageList.data.repository

import com.vonisak.composeImageList.data.converter.toImage
import com.vonisak.composeImageList.data.datasource.ImagesDataSource
import com.vonisak.composeImageList.domain.entity.Image
import com.vonisak.composeImageList.domain.repository.ImagesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ImagesRepositoryImpl @Inject constructor(private val dataSource: ImagesDataSource) :
    ImagesRepository {

    override suspend fun getImages(): List<Image> =
        dataSource.getImages().map { responseImage -> responseImage.toImage() }
}