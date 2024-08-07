package com.example.retrofitdrill.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.retrofitdrill.AnimalInfoApplication
import com.example.retrofitdrill.data.AnimalInfoRepository
import com.example.retrofitdrill.network.model.Item
import kotlinx.coroutines.launch

class AnimalListViewModel(private val animalInfoRepository: AnimalInfoRepository) : ViewModel() {

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
            try {
                val response = animalInfoRepository.getAnimalInfo("$currentPage")
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

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AnimalInfoApplication)
                val animalInfoRepository = application.container.animalInfoRepository
                AnimalListViewModel(animalInfoRepository = animalInfoRepository)
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