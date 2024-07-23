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

    init {
        getAnimalInfo()
    }

    private var page = 0

    fun getAnimalInfo() {
        viewModelScope.launch {
            _status.value = AnimalUiState.Loading
            try {
                val response = AnimalApi.retrofitService.getAnimalInfo("${++page}")
                if (response.isSuccessful) {
                    val result = response.body()?.response?.body?.items?.item
                    _status.value = AnimalUiState.Success(animalList = result)
                    _animalList.value = result
                }
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}