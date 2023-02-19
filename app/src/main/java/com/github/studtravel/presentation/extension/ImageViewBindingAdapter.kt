package com.github.studtravel.presentation.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.github.studtravel.R

@BindingAdapter(value = ["imageItem", "transformation"], requireAll = false)
fun ImageView.setImageItem(url: String?, transformation: BitmapTransformation?) {
    val loader = Glide.with(context)
        .load(url)
        .placeholder(R.drawable.ic_launcher_background)
        .error(R.drawable.ic_launcher_background)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)

    transformation?.let {
        loader.transform(transformation)
    }

    loader.into(this)
}

