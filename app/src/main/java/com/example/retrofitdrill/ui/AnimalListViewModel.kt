package com.example.retrofitdrill.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitdrill.network.AnimalApi
import com.example.retrofitdrill.network.model.Item
import kotlinx.coroutines.launch

sealed interface AnimalUiState {
    data class Success(val animalList: List<Item>?) : AnimalUiState
    data object Error : AnimalUiState
    data object Loading : AnimalUiState
}

class AnimalListViewModel : ViewModel() {

    private val _status = MutableLiveData<AnimalUiState>()
    val status: LiveData<AnimalUiState> get() = _status

    private val _animalList = MutableLiveData<List<Item>?>()
    val animalList: LiveData<List<Item>?> get() = _animalList

    private var currentPage = 1
    private var isLoading = false
    private var hasMoreData = true

    init {
        resetPagination()
    }

    fun getAnimalInfo() {
        if (isLoading || !hasMoreData) return

        viewModelScope.launch {
            isLoading = true
            _status.value = AnimalUiState.Loading
            try {
                val response = AnimalApi.retrofitService.getAnimalInfo("$currentPage")
                if (response.isSuccessful) {
                    val newAnimals = response.body()?.response?.body?.items?.item
                    val currentList = _animalList.value.orEmpty()
                    _animalList.value = currentList + newAnimals!!
                    currentPage++
                    hasMoreData = newAnimals.isNotEmpty()
                }
            } catch (e: Exception) {
                Log.e("exception", "$e")
            } finally {
                isLoading = false
            }
        }
    }

    private fun resetPagination() {
        currentPage = 1
        hasMoreData = true
        _animalList.value = emptyList()
        getAnimalInfo()
    }
}