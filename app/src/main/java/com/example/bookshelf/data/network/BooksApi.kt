package com.example.bookshelf.data.network

import com.example.bookshelf.model.BooksApiResponse
import com.example.bookshelf.model.Volume
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksApi {
    @GET("volumes")
    suspend fun getVolumes(): BooksApiResponse

    @GET("volumes/{volumeId}")
    suspend fun getVolumeById(@Path("volumeId") id: String): Volume
}