package com.example.bookshelf.data

import com.example.bookshelf.data.network.FakeBooksApi
import com.example.bookshelf.model.BookshelfItem

object FakeBookshelfRepository: BookshelfRepository {
    override suspend fun getVolumes(): List<String> {
        val volumeIdList = mutableListOf<String>()
        FakeBooksApi.getVolumes().volumeItems.forEach { volumeIdList.add(it.id) }

        return volumeIdList
    }

    override suspend fun getVolumeById(id: String): BookshelfItem {
        val volume = FakeBooksApi.getVolumeById(id)

        return BookshelfItem(
            title = volume.volumeInfo.title,
            image = volume.volumeInfo.imageLinks.link.replace("http://", "https://")
        )
    }
}