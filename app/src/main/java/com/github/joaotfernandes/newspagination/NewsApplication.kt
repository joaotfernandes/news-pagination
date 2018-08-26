package com.github.joaotfernandes.newspagination

import android.app.Application
import androidx.paging.DataSource
import com.github.joaotfernandes.newspagination.pagination.ArticlesDataSourceFactory
import com.github.joaotfernandes.newspagination.service.NewsService
import com.github.joaotfernandes.newspagination.service.RetrofitNewsService
import com.github.joaotfernandes.newspagination.service.model.Article
import org.koin.android.ext.android.startKoin
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import java.util.*

class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val module = module {
            single { RetrofitNewsService(BuildConfig.NEWS_API_KEY) as NewsService }

            single {
                ArticlesDataSourceFactory(get(), getProperty("article_keywords"), Locale.getDefault().language)
                    as DataSource.Factory<Int, Article>
            }

            viewModel { NewsViewModel(get()) }
        }

        startKoin(this, listOf(module))
    }
}
