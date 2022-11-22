package com.vonisak.composeImageList.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.vonisak.composeImageList.domain.entity.Image
import com.vonisak.composeImageList.domain.usecase.GetImagesUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ImagesViewModel @Inject constructor(private val getImagesUseCase: GetImagesUseCase) :
    ViewModel() {

    private val _imagesState = mutableStateListOf<Image>()
    val imagesState: List<Image> = _imagesState

    fun getImages() {
        CoroutineScope(Dispatchers.IO).launch {
            if (_imagesState.isEmpty()) {
                _imagesState.addAll(getImagesUseCase())
            }

        }
    }

    fun deleteImage(image: Image) {
        _imagesState.remove(image)
    }
}