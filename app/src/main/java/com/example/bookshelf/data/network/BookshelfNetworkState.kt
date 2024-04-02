package com.example.bookshelf.data.network

import com.example.bookshelf.model.BookshelfItem

interface BookshelfNetworkState {
    data class Success(val items: List<BookshelfItem>) : BookshelfNetworkState
    data object Loading : BookshelfNetworkState
    data class Error(val errorMessage: String) : BookshelfNetworkState
}