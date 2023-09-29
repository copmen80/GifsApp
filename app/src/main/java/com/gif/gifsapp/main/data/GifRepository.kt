package com.gif.gifsapp.main.data

import javax.inject.Inject

class GifRepository @Inject constructor(
    private val gifService: GifService
) {
    suspend fun getGifList() = gifService.getGifList()
}