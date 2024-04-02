package com.example.bookshelf.data.network

import com.example.bookshelf.model.Volume

object FakeBooksApi: BooksApi {
    override suspend fun getVolumes() = FakeNetworkDataSource.fakeResponse

    override suspend fun getVolumeById(id: String): Volume = FakeNetworkDataSource.fakeResponse.volumeItems[0]
}