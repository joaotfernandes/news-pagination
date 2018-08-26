package com.github.joaotfernandes.newspagination

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.Date

private val dateFormatter = SimpleDateFormat("HH:mm 'on' MMM dd, yyyy")

@BindingAdapter("publishedAt")
fun setPublishedAt(view: TextView, date: Date) {
    view.text = dateFormatter.format(date)
}
