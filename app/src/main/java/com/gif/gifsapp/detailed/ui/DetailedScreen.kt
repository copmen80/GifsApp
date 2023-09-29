package com.gif.gifsapp.detailed.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gif.gifsapp.main.ui.GifImage

@Composable
fun DetailedScreen(
    url: String
) {
        GifImage(modifier = Modifier.fillMaxSize(), url = url, itemClick = {})
}