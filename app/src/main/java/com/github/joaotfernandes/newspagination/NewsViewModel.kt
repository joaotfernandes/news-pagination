package com.github.joaotfernandes.newspagination

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.github.joaotfernandes.newspagination.service.model.Article

private const val PAGE_SIZE = 20

class NewsViewModel(dataSourceFactory: DataSource.Factory<Int, Article>) : ViewModel() {

    val articles: LiveData<PagedList<Article>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(false)
            .build()

        articles = LivePagedListBuilder(dataSourceFactory, config).build()
    }
}
