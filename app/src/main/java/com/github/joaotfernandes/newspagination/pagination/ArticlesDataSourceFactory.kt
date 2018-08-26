package com.github.joaotfernandes.newspagination.pagination

import androidx.paging.DataSource
import com.github.joaotfernandes.newspagination.service.NewsService
import com.github.joaotfernandes.newspagination.service.model.Article

class ArticlesDataSourceFactory(
    private val newsService: NewsService,
    private val articleKeywords: String,
    private val articleLanguage: String
) : DataSource.Factory<Int, Article>() {

    override fun create() = ArticlesPagedDataSource(newsService, articleKeywords, articleLanguage)
}
