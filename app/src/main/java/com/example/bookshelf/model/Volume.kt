package com.example.bookshelf.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Volume(
    @SerialName(value = "id") val id: String,
    @SerialName(value = "selfLink") val selfLink: String,
    @SerialName(value = "volumeInfo") val volumeInfo: VolumeInfo
)
