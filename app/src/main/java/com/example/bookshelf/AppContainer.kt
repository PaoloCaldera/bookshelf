package com.example.bookshelf

import com.example.bookshelf.data.network.BooksApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val booksService: BooksApi
}

object MainAppContainer : AppContainer {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl("https://www.googleapis.com/books/v1")
        .build()

    override val booksService: BooksApi by lazy {
        retrofit.create(BooksApi::class.java)
    }
}