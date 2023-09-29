package com.gif.gifsapp.main.ui

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = viewModel(),
    itemClick: (String) -> Unit
) {
    viewModel.getGifList()
    val gifItems = viewModel.content.collectAsState()

    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        cells = GridCells.Adaptive(128.dp)
    ) {
        items(gifItems.value.size) { item ->
            GifImage(url = gifItems.value[item].url, itemClick = itemClick,contentScale = ContentScale.Crop)
        }
    }
}

@Composable
fun GifImage(
    url: String,
    modifier: Modifier = Modifier,
    itemClick: (String) -> Unit,
    contentScale: ContentScale = ContentScale.Fit
) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context).data(data = url).apply(block = {
                size(Size.ORIGINAL)
            }).build(), imageLoader = imageLoader
        ),
        contentDescription = null,
        modifier = modifier
            .size(70.dp)
            .clickable { itemClick.invoke(url) },
        contentScale = contentScale
    )
}
