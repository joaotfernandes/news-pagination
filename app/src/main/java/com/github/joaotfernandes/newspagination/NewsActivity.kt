package com.github.joaotfernandes.newspagination

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_news.articlesRecyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsActivity : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val adapter = ArticlesAdapter()
        articlesRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        articlesRecyclerView.adapter = adapter

        viewModel.articles.observe(this, Observer { adapter.submitList(it) })
    }
}
