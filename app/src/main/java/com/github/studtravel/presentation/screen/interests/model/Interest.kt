package com.github.studtravel.presentation.screen.interests.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Interest(
  @DrawableRes
  val iconResId: Int,
  @StringRes
  val textResId: Int,
  val isChecked: Boolean
)
