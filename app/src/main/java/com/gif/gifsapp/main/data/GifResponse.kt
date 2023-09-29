package com.gif.gifsapp.main.data

import com.google.gson.annotations.SerializedName

data class GifResponse(
    @field:SerializedName("data")
    val data: ArrayList<Gif>,
)

data class Gif(
    @field:SerializedName("id")
    val id: String,
    @field:SerializedName("url")
    val url: String,
    @field:SerializedName("images")
    val images: Images
)

data class Images(
    @field:SerializedName("original")
    val original: Original,
)

data class Original(
    @field:SerializedName("url")
    val url: String,
)