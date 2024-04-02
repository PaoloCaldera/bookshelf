package com.example.bookshelf.ui.viewmodel

import com.example.bookshelf.TestDispatcherRule
import com.example.bookshelf.data.FakeBookshelfRepository
import com.example.bookshelf.data.network.BookshelfNetworkState
import com.example.bookshelf.model.BookshelfItem
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class BookshelfViewModelTest {

    @get:Rule
    val testDispatcherRule = TestDispatcherRule()

    @Test
    fun getBookshelf_fakeRepository_verifyUiState() {
        val viewModel = BookshelfViewModel(FakeBookshelfRepository)

        val expectedBookshelfItems = mutableListOf<BookshelfItem>()
        runTest {
            FakeBookshelfRepository.getVolumes().forEach {
                expectedBookshelfItems.add(FakeBookshelfRepository.getVolumeById(it))
            }
        }

        assertEquals(
            BookshelfNetworkState.Success(expectedBookshelfItems),
            viewModel.uiState.value.networkState
        )
    }
}