package com.example.retrofitdrill

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdrill.network.model.Item
import com.example.retrofitdrill.ui.AnimalListRVAdapter


@BindingAdapter("animalList")
fun setAnimalList(recyclerView: RecyclerView, data: List<Item>?) {
    val adapter = recyclerView.adapter as? AnimalListRVAdapter
    adapter?.submitList(data)
}



@BindingAdapter("onScrollListener")
fun setOnScrollListener(recyclerView: RecyclerView, loadMore: () -> Unit) {
    recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = recyclerView.layoutManager as GridLayoutManager
            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                && firstVisibleItemPosition >= 0
            ) {
                loadMore()
            }
        }
    })
}