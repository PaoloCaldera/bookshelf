package com.example.bookshelf.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.MainAppContainer
import com.example.bookshelf.data.BookshelfNetworkRepository
import com.example.bookshelf.data.BookshelfRepository
import com.example.bookshelf.data.network.BookshelfNetworkState
import com.example.bookshelf.model.BookshelfItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class BookshelfViewModel(private val repository: BookshelfRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(BookshelfUiState(BookshelfNetworkState.Loading))
    val uiState: StateFlow<BookshelfUiState> = _uiState.asStateFlow()

    init {
        getBookshelf()
    }

    fun getBookshelf() {
        viewModelScope.launch {
            _uiState.update { it.copy(networkState = BookshelfNetworkState.Loading) }

            try {
                val bookshelfItemList = mutableListOf<BookshelfItem>()

                repository.getVolumes().forEach {
                    bookshelfItemList.add(repository.getVolumeById(it))
                }
                _uiState.update {
                    it.copy(networkState = BookshelfNetworkState.Success(bookshelfItemList))
                }
            } catch (e: IOException) {
                _uiState.update {
                    it.copy(networkState = BookshelfNetworkState.Error(e.message ?: "IO Exception"))
                }
            } catch (e: HttpException) {
                _uiState.update {
                    it.copy(networkState = BookshelfNetworkState.Error(e.message ?: "HttpException"))
                }
            }
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                BookshelfViewModel(BookshelfNetworkRepository(MainAppContainer.booksService))
            }
        }
    }
}