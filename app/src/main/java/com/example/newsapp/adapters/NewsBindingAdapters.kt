package com.example.newsapp.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.newsapp.models.Article

@BindingAdapter("articleTitle")
fun TextView.setArticleTitle(article: Article?) {
    article?.let {
        text = it.title
    }
}

@BindingAdapter("articleDescription")
fun TextView.setArticleDescription(article: Article?) {
    article?.let {
        text = it.description
    }
}

@BindingAdapter("articlePublishedAt")
fun TextView.setArticlePublishedAt(article: Article?) {
    article?.let {
        text = it.publishedAt
    }
}

@BindingAdapter("articleSource")
fun TextView.setArticleSource(article: Article?) {
    article?.let {
        text = it.source.name
    }
}

@BindingAdapter("articleImage")
fun ImageView.setArticleImage(article: Article?) {
    article?.let {
        if (article.urlToImage != null) {
            Glide.with(this).load(article.urlToImage).into(
                this
            )
        }
    }
}