package com.github.joaotfernandes.newspagination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.joaotfernandes.newspagination.databinding.ItemArticleBinding
import com.github.joaotfernandes.newspagination.service.model.Article

class ArticlesAdapter(private val onArticleClicked: (Article) -> Unit)
    : PagedListAdapter<Article, ArticlesAdapter.ArticleViewHolder>(ArticleDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ArticleViewHolder(ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ArticleViewHolder(private val binder: ItemArticleBinding) : RecyclerView.ViewHolder(binder.root) {

        fun bind(article: Article) {
            binder.article = article
            binder.root.setOnClickListener { onArticleClicked(article) }
            binder.executePendingBindings()
        }
    }

    private object ArticleDiff : DiffUtil.ItemCallback<Article>() {

        override fun areItemsTheSame(oldItem: Article, newItem: Article) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            // In this case, if items are the same then content will always be the same
            return true
        }

    }
}
