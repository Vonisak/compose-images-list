package com.vonisak.composeImageList.di.module

import com.vonisak.composeImageList.data.network.ImagesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    private companion object {

        const val BASE_URL = "https://637cab0016c1b892ebbb4e11.mockapi.io/"
    }

    @Provides
    fun provideBaseUrl(): String =
        BASE_URL

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Provides
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        baseUrl: String,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build()

    @Provides
    fun provideRetrofitProfileApi(retrofit: Retrofit): ImagesApi = retrofit.create(
        ImagesApi::class.java
    )
}