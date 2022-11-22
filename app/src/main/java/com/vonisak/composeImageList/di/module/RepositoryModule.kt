package com.vonisak.composeImageList.di.module

import com.vonisak.composeImageList.data.repository.ImagesRepositoryImpl
import com.vonisak.composeImageList.domain.repository.ImagesRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindImagesRepository(impl: ImagesRepositoryImpl): ImagesRepository
}