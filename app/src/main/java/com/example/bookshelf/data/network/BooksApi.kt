package com.example.bookshelf.data.network

import com.example.bookshelf.model.BooksApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksApi {

    @GET("volumes")
    fun getVolumes(): BooksApiResponse

    @GET("volumes/{volumeId}")
    fun getVolumeById(@Path("volumeId") id: String)
}