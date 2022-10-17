package com.uaref.bindingAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.maxshop.model.RecyclerItem
import com.squareup.picasso.Picasso
import com.uaref.adapter.DataBindingRecyclerAdapter
import com.uaref.fragment.R

@BindingAdapter("android:srcImage")
fun setImage(view: ImageView, imageUrl: String?) {
    Picasso.with(view.context)
        .load(imageUrl)
        .placeholder(R.drawable.loading_anim)
        .fit()
        .centerCrop()
        .into(view)
}

@BindingAdapter("items")
fun setItems(view: RecyclerView, items: List<RecyclerItem>?) {
    var adapter = view.adapter as? DataBindingRecyclerAdapter
    if (adapter == null) {
        adapter = DataBindingRecyclerAdapter()
        view.adapter = adapter
    }
    adapter.submitList(items)
}
