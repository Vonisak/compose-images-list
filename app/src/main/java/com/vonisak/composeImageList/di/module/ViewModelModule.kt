package com.vonisak.composeImageList.di.module

import androidx.lifecycle.ViewModel
import com.vonisak.composeImageList.di.viewmodelFactory.ViewModelKey
import com.vonisak.composeImageList.presentation.viewmodel.ImagesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ImagesViewModel::class)
    abstract fun bindImagesViewModel(viewModel: ImagesViewModel): ViewModel
}