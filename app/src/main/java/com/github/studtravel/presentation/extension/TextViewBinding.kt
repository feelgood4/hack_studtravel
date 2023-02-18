package com.github.studtravel.presentation.extension

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("minPrice")
fun TextView.minPrice(minPrice: Double?) {
    val result = if (minPrice != null) "От $minPrice ₽" else "Цена неизвестна"
    text = result
}
