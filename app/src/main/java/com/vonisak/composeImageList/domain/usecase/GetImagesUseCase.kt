package com.vonisak.composeImageList.domain.usecase

import com.vonisak.composeImageList.domain.entity.Image
import com.vonisak.composeImageList.domain.repository.ImagesRepository
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(private val repository: ImagesRepository) {

    suspend operator fun invoke(): List<Image> = repository.getImages()
}