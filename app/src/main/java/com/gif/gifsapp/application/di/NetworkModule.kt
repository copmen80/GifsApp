package com.gif.gifsapp.application.di

import com.gif.gifsapp.main.data.GifService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideGifService(retrofit: Retrofit): GifService =
        retrofit.create(GifService::class.java)
}
