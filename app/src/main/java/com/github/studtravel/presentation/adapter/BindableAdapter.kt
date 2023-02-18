package com.github.studtravel.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.studtravel.presentation.model.recyclerview.RecyclerViewItem


class BindableAdapter<T : RecyclerViewItem> :
    RecyclerView.Adapter<BindableAdapter.BindableViewHolder<T>>() {

    private val dataList: MutableList<T> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return BindableViewHolder(viewBinding)
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].layoutId
    }

    override fun onBindViewHolder(holder: BindableViewHolder<T>, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setItems(inputUserList: List<T>) {
        val diffCallback = DataDiffUtilCallback(dataList, inputUserList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        dataList.clear()
        dataList.addAll(inputUserList)
        diffResult.dispatchUpdatesTo(this)
    }

    class BindableViewHolder<T : RecyclerViewItem>(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: T) {
            binding.setVariable(data.variableId, data)
        }
    }
}
