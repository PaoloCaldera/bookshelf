package com.example.bookshelf.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VolumeImageLinks(
    @SerialName(value = "thumbnail") val link: String
)
