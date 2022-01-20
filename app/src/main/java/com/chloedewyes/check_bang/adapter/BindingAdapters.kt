package com.chloedewyes.check_bang.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chloedewyes.check_bang.models.Item

@BindingAdapter("app:bindSearchBook")
fun bindSearchBook(recyclerView: RecyclerView, searchBook: List<Item>?) {
    val adapter = recyclerView.adapter as? BookAdapter
    adapter?.submitList(searchBook)
}

@BindingAdapter("app:bindBookImage")
fun bindBookImage(imageView: ImageView, image: String){
    Glide.with(imageView.context)
        .load(image)
        .into(imageView)
}