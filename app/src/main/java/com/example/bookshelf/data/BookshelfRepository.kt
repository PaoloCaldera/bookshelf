package com.example.bookshelf.data

import com.example.bookshelf.data.network.BooksApi
import com.example.bookshelf.model.BookshelfItem

interface BookshelfRepository {
    suspend fun getVolumes(): List<String>
    suspend fun getVolumeById(id: String): BookshelfItem
}

class BookshelfNetworkRepository(private val booksService: BooksApi) : BookshelfRepository {
    override suspend fun getVolumes(): List<String> {
        val volumeIdList = mutableListOf<String>()
        booksService.getVolumes().volumeItems.forEach { volumeIdList.add(it.id) }

        return volumeIdList
    }

    override suspend fun getVolumeById(id: String): BookshelfItem {
        val volume = booksService.getVolumeById(id)

        return BookshelfItem(
            title = volume.volumeInfo.title,
            image = volume.volumeInfo.imageLinks.link.replace("http://", "https://")
        )
    }

}