package com.github.studtravel.presentation.extension

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.studtravel.presentation.adapter.BindableAdapter
import com.github.studtravel.presentation.model.recyclerview.RecyclerViewItem

@Suppress("UNCHECKED_CAST")
@BindingAdapter("items")
fun <T : RecyclerViewItem> RecyclerView.setItems(
    items: List<T>?
) {
    val insertItems = items ?: emptyList()
    (adapter as? BindableAdapter<T>)?.setItems(insertItems) ?: run {
        if (adapter !is RecyclerView.Adapter) {
            val adapter = BindableAdapter<T>()
            adapter.setItems(insertItems)
            this.adapter = adapter
        }
    }
}

