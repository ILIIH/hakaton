package com.uaref.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.recyclerview.widget.ListAdapter
import com.maxshop.model.RecyclerItem
import com.uaref.adapter.callback.DiffCallback
import com.uaref.adapter.viewHolder.BindingViewHolder

class DataBindingRecyclerAdapter : ListAdapter<RecyclerItem, BindingViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(inflater, viewType, parent, false)
        binding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: BindingViewHolder,
        position: Int
    ) {
        holder.run {
            getItem(position).bind(binding)
            if (binding.hasPendingBindings()) {
                binding.executePendingBindings()
            }
        }
    }

    override fun getItemViewType(position: Int) = getItem(position).layoutId
}
