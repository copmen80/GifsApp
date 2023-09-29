package com.gif.gifsapp.main.data

import retrofit2.http.GET
import retrofit2.http.Query


interface GifService {
    @GET("/v1/gifs/trending")
    suspend fun getGifList(
        @Query("api_key") apiKey: String = "7fIvJYYvepz2N1DNRhLXqwpt9d1SmfxY",
        @Query("limit") limit: Int = 50,
    ): GifResponse
}