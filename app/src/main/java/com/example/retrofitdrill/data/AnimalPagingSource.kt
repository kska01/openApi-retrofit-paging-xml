package com.example.retrofitdrill.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.retrofitdrill.network.AnimalsApiService
import com.example.retrofitdrill.network.model.Item

class AnimalPagingSource(
    private val service: AnimalsApiService,
    private val query: String
) : PagingSource<Int, Item>() {
    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        TODO("Not yet implemented")
    }
}