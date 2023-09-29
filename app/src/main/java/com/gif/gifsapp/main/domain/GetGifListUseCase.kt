package com.gif.gifsapp.main.domain

import com.gif.gifsapp.main.data.GifRepository
import javax.inject.Inject

class GetGifListUseCase @Inject constructor(
    private val gifRepository: GifRepository
) {
    suspend fun invoke() = gifRepository.getGifList()
}