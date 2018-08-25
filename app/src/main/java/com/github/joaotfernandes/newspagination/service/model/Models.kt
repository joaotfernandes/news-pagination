package com.github.joaotfernandes.newspagination.service.model

import java.util.Date

data class NewsResponse(val status: String, val totalResults: Int, val articles: List<Article>)

data class Article(val title: String, val description: String, val publishedAt: Date, val url: String, val source: Source)

data class Source(val name: String)
