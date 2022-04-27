package com.example.newsapp

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class FavouritesViewModel(private val repositry: FavoRepositry):ViewModel() {
    val allfavo: LiveData<List<DataItem>> = repositry.allfavo.asLiveData()

    fun insert(dataitem:DataItem) = viewModelScope.launch {
        repositry.insert(dataitem)
   }
    fun delete(dataitem: DataItem) = viewModelScope.launch {
        repositry.delete(dataitem)
    }
    class FavouritesViewModelFactory(private val repositry: FavoRepositry):ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(FavouritesViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return FavouritesViewModel(repositry) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    }
