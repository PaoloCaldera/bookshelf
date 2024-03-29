package com.example.bookshelf.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
    @SerialName("title") val title: String,
    @SerialName("imageLinks") val imageLinks: VolumeImageLinks
)
