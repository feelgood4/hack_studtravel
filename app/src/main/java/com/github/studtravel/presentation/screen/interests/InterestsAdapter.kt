package com.github.studtravel.presentation.screen.interests

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.studtravel.R
import com.github.studtravel.databinding.InterestItemBinding
import com.github.studtravel.presentation.screen.interests.model.Interest

class InterestsAdapter(
  private val interests: List<Interest>,
  private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<InterestsAdapter.InterestsHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterestsAdapter.InterestsHolder {
    val itemBinding = InterestItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return InterestsHolder(itemBinding)
  }

  override fun onBindViewHolder(holder: InterestsAdapter.InterestsHolder, position: Int) {
    holder.bindItem(interests[position], position)
  }

  override fun getItemCount(): Int = interests.size

  inner class InterestsHolder(private val itemBinding: InterestItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bindItem(item: Interest, itemId: Int) {
      itemView.apply {
        itemBinding.icon.setImageResource(item.iconResId)
        itemBinding.mainText.text = resources.getString(item.textResId)

        val backgroundResId = if (item.isChecked) {
          R.drawable.checked_shape
        } else R.drawable.unchecked_shape
        itemBinding.background.setBackgroundResource(backgroundResId)

        setOnClickListener {
          onItemClick(itemId)
        }
      }
    }
  }
}