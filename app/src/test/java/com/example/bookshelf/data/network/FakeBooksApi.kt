package com.example.bookshelf.data.network

object FakeBooksApi: BooksApi {
    override suspend fun getVolumes(filter: String) = FakeNetworkDataSource.fakeResponse

    override suspend fun getVolumeById(id: String) = FakeNetworkDataSource.fakeResponse.volumeItems[0]
}