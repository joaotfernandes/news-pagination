package com.github.joaotfernandes.newspagination.pagination

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.github.joaotfernandes.newspagination.service.NewsService
import com.github.joaotfernandes.newspagination.service.model.Article
import com.github.joaotfernandes.newspagination.service.model.NewsResponse

private const val INITIAL_PAGE_KEY = 1

class ArticlesPagedDataSource(
    private val newsService: NewsService,
    private val articleKeyword: String,
    private val articleLanguage: String
) : PageKeyedDataSource<Int, Article>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Article>) {
        loadArticles(INITIAL_PAGE_KEY, params.requestedLoadSize) {
            callback.onResult(it.articles, null, INITIAL_PAGE_KEY + 1)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Article>) {
        loadArticles(params.key, params.requestedLoadSize) { callback.onResult(it.articles, params.key + 1) }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Article>) {
        loadArticles(params.key, params.requestedLoadSize) { callback.onResult(it.articles, params.key - 1) }
    }

    private fun loadArticles(page: Int, pageSize: Int, callback: (NewsResponse) -> Unit) {
        newsService.getArticles(articleKeyword, articleLanguage, page, pageSize)
            .doOnError { Log.e("ArticlesPagedDataSource", "Failed to load articles", it) }
            .doOnSuccess {
                if (it.isSuccessful) {
                    it.body()?.let { callback(it) }
                }
            }.run()
    }
}
