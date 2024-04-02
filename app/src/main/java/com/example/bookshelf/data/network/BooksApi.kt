package com.example.bookshelf.data.network

import com.example.bookshelf.model.BooksApiResponse
import com.example.bookshelf.model.Volume
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApi {
    @GET("volumes")
    suspend fun getVolumes(@Query("q") filter: String = "jazz+history"): BooksApiResponse

    @GET("volumes/{volumeId}")
    suspend fun getVolumeById(@Path("volumeId") id: String): Volume
}