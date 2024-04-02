package com.example.bookshelf.data

import com.example.bookshelf.data.network.FakeBooksApi
import com.example.bookshelf.data.network.FakeNetworkDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class BookshelfRepositoryTest {

    @Test
    fun getVolumes_fakeBooksApi_verifyOutput() = runTest {
        val repository = BookshelfNetworkRepository(FakeBooksApi)

        val expectedStringList = mutableListOf<String>()
        FakeNetworkDataSource.fakeResponse.volumeItems.forEach { expectedStringList.add(it.id) }

        assertEquals(expectedStringList.toList(), repository.getVolumes())
    }

    @Test
    fun getVolumeById_fakeBooksApi_verifyOutput() = runTest {
        val repository = BookshelfNetworkRepository(FakeBooksApi)

        val expectedTitle = "La storia del jazz"
        val firstVolumeId = FakeNetworkDataSource.fakeResponse.volumeItems[0].id

        assertEquals(expectedTitle, repository.getVolumeById(firstVolumeId).title)
    }
}