package com.github.joaotfernandes.newspagination.service

import com.github.joaotfernandes.newspagination.service.model.NewsResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import java.util.Date

private const val NEWS_API_BASE_URL = "https://newsapi.org/v2/"

class RetrofitNewsService(private val apiKey: String) : NewsService {

    private val api: NewsApi

    init {
        api = Retrofit.Builder()
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder()
                        .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
                        .add(KotlinJsonAdapterFactory())
                        .build()
                )
            )
            .baseUrl(NEWS_API_BASE_URL)
            .build()
            .create(NewsApi::class.java)
    }

    override fun getArticles(keywords: String, language: String, page: Int, pageSize: Int) =
        api.getArticles(keywords, language, page, pageSize, apiKey).toSimpleCall()

    interface NewsApi {

        @GET("everything?sortBy=publishedAt")
        fun getArticles(
            @Query("q") keyword: String,
            @Query("language") language: String,
            @Query("page") page: Int,
            @Query("pageSize") pageSize: Int,
            @Header("X-Api-Key") apiKey: String
        ): Call<NewsResponse>
    }
}
