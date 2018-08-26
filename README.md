# News (with paging)
Sample news application to test the [Android Paging Library](https://developer.android.com/topic/libraries/architecture/paging/) when fetching data from a network data source. In this case, the data source is the [NewsAPI](https://newsapi.org/). 

![News demo](/assets/news.gif)

## Build
To build this application locally you will need to provide an API key to use the [NewsAPI](https://newsapi.org/). To do so you can get an API key from https://newsapi.org/register and add `news_api_key=<key>` to `gradle.properties`.

import the project into Android Studio (3.1+)

## Error handling
To keep the sample focused on the Paging Library, errors are logged to the logcat and there is no error UI.

## Libraries
* [Android Support Library](https://developer.android.com/topic/libraries/support-library/features)
* [Paging Library](https://developer.android.com/topic/libraries/architecture/paging/)
* [Data Binding Library](https://developer.android.com/topic/libraries/data-binding/)
* [ConstraintLayout](https://developer.android.com/reference/android/support/constraint/ConstraintLayout)
* [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)
* [Cardview](https://developer.android.com/guide/topics/ui/layout/cardview)
* [Retrofit2](https://square.github.io/retrofit/) for network requests
* [Moshi](https://github.com/square/moshi) for JSON parsing
* [Koin](https://insert-koin.io/) for dependency injection
