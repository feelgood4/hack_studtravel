package com.github.studtravel.presentation.extension

import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.github.studtravel.R

@BindingAdapter("minPrice")
fun TextView.minPrice(minPrice: Double?) {
    val result = if (minPrice != null) "От $minPrice ₽" else "Цена неизвестна"
    text = result
}

@BindingAdapter("countVariants")
fun TextView.countVariants(countVariants: Int?) {
    text = context.getString(R.string.count_variants, countVariants ?: 0)
}
