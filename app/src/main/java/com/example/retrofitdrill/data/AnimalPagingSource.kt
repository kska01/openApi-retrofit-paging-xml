package com.example.retrofitdrill.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.retrofitdrill.network.AnimalsApiService
import com.example.retrofitdrill.network.model.Item
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1
class AnimalPagingSource(
    private val service: AnimalsApiService
) : PagingSource<Int, Item>() {
    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        val position = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = service.getAnimalInfo(position.toString())
            val animals = response.body()?.response?.body?.items?.item
            val nextKey = if (animals?.isEmpty()!!) {
                null
            } else {
                position + 1
            }
            LoadResult.Page(
                data = animals,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}