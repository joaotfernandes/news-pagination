package com.github.joaotfernandes.newspagination.service

import com.github.joaotfernandes.newspagination.service.model.NewsResponse

private const val DEFAULT_HEADLINES_PAGE = 1
private const val DEFAULT_HEADLINES_PER_PAGE = 20

interface NewsService {

    /**
     * Provides articles that have a match the given [keywords].
     *
     * Articles are sorted by the earliest date published first.
     *
     * @param keywords keywords to search for
     * @param language the 2-letter ISO-639-1 code of the language the articles will be returned for
     * @param page should be greater or equal than 1 and allows to page through the results if the total results found is greater than
     * [pageSize]. By default the first page will be returned.
     * @param pageSize the number of results to return. 20 is the default value, 100 is the maximum
     */
    fun getArticles(
        keywords: String,
        language: String,
        page: Int = DEFAULT_HEADLINES_PAGE,
        pageSize: Int = DEFAULT_HEADLINES_PER_PAGE
    ): SimpleCall<NewsResponse>
}
