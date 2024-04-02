package com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.data.network.BookshelfNetworkState
import com.example.bookshelf.ui.screens.BookshelfErrorScreen
import com.example.bookshelf.ui.screens.BookshelfLoadingScreen
import com.example.bookshelf.ui.screens.BookshelfSuccessScreen
import com.example.bookshelf.ui.theme.BookshelfTheme
import com.example.bookshelf.ui.viewmodel.BookshelfViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookshelfTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BookshelfApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfApp(modifier: Modifier = Modifier) {
    val viewModel: BookshelfViewModel = viewModel(factory = BookshelfViewModel.Factory)
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            )
        }
    ) {
        when (val networkState = uiState.networkState) {
            is BookshelfNetworkState.Success -> {
                BookshelfSuccessScreen(
                    bookshelfItems = networkState.items,
                    modifier = modifier.fillMaxSize().padding(it)
                )
            }

            is BookshelfNetworkState.Error -> {
                BookshelfErrorScreen(
                    onRetry = { viewModel.getBookshelf() },
                    modifier = modifier.fillMaxSize().padding(it)
                )
            }

            is BookshelfNetworkState.Loading -> {
                BookshelfLoadingScreen(modifier = modifier.fillMaxSize().padding(it))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookshelfAppPreview() {
    BookshelfTheme {
        BookshelfApp(modifier = Modifier.fillMaxSize())
    }
}