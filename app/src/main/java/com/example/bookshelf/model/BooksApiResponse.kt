package com.example.bookshelf.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BooksApiResponse(
    @SerialName(value = "totalItems") val totalItems: Int,
    @SerialName(value = "items") val volumeItems: List<Volume>
)
