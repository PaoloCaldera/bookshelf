package com.example.bookshelf.data.network

import com.example.bookshelf.model.BooksApiResponse
import com.example.bookshelf.model.Volume
import com.example.bookshelf.model.VolumeImageLinks
import com.example.bookshelf.model.VolumeInfo

object FakeNetworkDataSource {
    val fakeResponse = BooksApiResponse(
        totalItems = 612,
        volumeItems = listOf(
            Volume(
                id = "cO8CEAAAQBAJ",
                selfLink = "https://www.googleapis.com/books/v1/volumes/cO8CEAAAQBAJ",
                volumeInfo = VolumeInfo(
                    title = "La storia del jazz",
                    imageLinks = VolumeImageLinks(
                        link = "http://books.google.com/books/content?id=cO8CEAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
                    )
                )
            ),
            Volume(
                id = "Z5Ot7ySoAMYC",
                selfLink = "https://www.googleapis.com/books/v1/volumes/Z5Ot7ySoAMYC",
                volumeInfo = VolumeInfo(
                    title = "Chicago Jazz",
                    imageLinks = VolumeImageLinks(
                        link = "http://books.google.com/books/content?id=Z5Ot7ySoAMYC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
                    )
                )
            )
        )
    )
}