package com.example.bookshelf.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.R
import com.example.bookshelf.model.BookshelfItem

@Composable
fun BookshelfLoadingScreen(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading_content_description),
        modifier = modifier.size(dimensionResource(R.dimen.loading_image_size))
    )
}

@Composable
fun BookshelfErrorScreen(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(dimensionResource(R.dimen.normal_padding))
    ) {
        Image(
            painter = painterResource(R.drawable.ic_connection_error),
            contentDescription = stringResource(R.string.error_content_description),
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.normal_padding)))
        Text(
            text = stringResource(R.string.connection_alert),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.normal_padding)))
        Button(onClick = { /*TODO*/ }) {
            Text(
                text = stringResource(R.string.retry_button),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun BookshelfSuccessScreen(
    bookshelfItems: List<BookshelfItem>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(columns = GridCells.Adaptive(dimensionResource(R.dimen.list_column_width))) {
        items(bookshelfItems) {
            BookshelfListItem(
                bookshelfItem = it,
                modifier = modifier
            )
        }
    }
}

@Composable
fun BookshelfListItem(
    bookshelfItem: BookshelfItem,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(R.dimen.card_elevation))
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(bookshelfItem.image)
                .crossfade(true)
                .build(),
            contentDescription = bookshelfItem.title,
            placeholder = painterResource(R.drawable.loading_img),
            error = painterResource(R.drawable.ic_broken_image),
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )
    }
}

