# Bookshelf

Bookshelf is the test project of the fifth unit of the *Android Basics with Compose* learning path, provided by Android Developers. It focuses on connecting to the internet and retrieving data from a remote web server by exploiting a third-party library called [Retrofit](https://square.github.io/retrofit/). In detail, the application connects to the [Google Books API](https://developers.google.com/books), retrieves information about volumes belonging to a certain category, and displays the images representing the covers of such volumes.

The project demonstrates the ability to connect to a web server via HTTP and retrieve data from that server using the [Retrofit](https://square.github.io/retrofit/) library. Moreover, it shows how to organize the application with a repository to handle the data layer, using the dependency injection best practice for testing. The main topics covered in this project are listed below:

* [Data Layer](https://developer.android.com/topic/architecture/data-layer) of the app, containing the logic for retrieving data from different sources and exposing them to the UI via a repository
* [Retrofit](https://square.github.io/retrofit/) for instantiating the client object performing the REST HTTP calls
* [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines), to apply multithreading to your app implementation
* [Dependency Injection](https://developer.android.com/training/dependency-injection), as one of the best practices in Android development, useful for testing purposes

The project comprises just one screen whose layout is developed through Jetpack Compose. The theme has been selected and created with the help of [Material Design 3 Theme Builder](https://m3.material.io/theme-builder#/custom).

Visit the [Wiki](https://github.com/PaoloCaldera/bookshelf/wiki) to see the application screens.


## Getting Started

To clone the repository, use the command
```
$ git clone https://github.com/PaoloCaldera/bookshelf.git
```
or the `Get from VCS` option inside Android Studio by copying the link above.

Then, run the application on an Android device or emulator. The application is compiled with API 34, thus use a device or emulator supporting such API version.

## License

Bookshelf is a public project that can be downloaded and modified under the terms and conditions of the [MIT License]().
