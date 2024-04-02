package com.example.bookshelf.data.network

import com.example.bookshelf.MainAppContainer
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class NetworkDataSourceTest {

    @Test
    fun networkDataSource_getData_verifyBody() = runTest {
        val api = MainAppContainer.booksService

        val volumes = api.getVolumes()
        assertNotEquals(0, volumes.volumeItems.size)

        val firstVolume = api.getVolumeById(volumes.volumeItems[0].id)
        assertEquals("La storia del jazz", firstVolume.volumeInfo.title)
    }
}