package com.vonisak.composeImageList.data.converter

import com.vonisak.composeImageList.data.model.ResponseImage
import com.vonisak.composeImageList.domain.entity.Image

fun ResponseImage.toImage(): Image = Image(this.id, this.url)