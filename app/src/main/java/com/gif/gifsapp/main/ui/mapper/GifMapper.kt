package com.gif.gifsapp.main.ui.mapper

import com.gif.gifsapp.main.data.Gif
import com.gif.gifsapp.main.ui.model.GifUiModel
import javax.inject.Inject

class GifMapper @Inject constructor() {
    fun map(gif: Gif): GifUiModel {
        return GifUiModel(
            id = gif.id,
            url = gif.images.original.url
        )
    }
}