package com.example.newsapp

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class FavouritesViewModel(private val repositry: FavoRepositry) : ViewModel() {

    fun getNewsList() {

    }

    val allfavo: LiveData<List<Articles>> = repositry.allfavlist.asLiveData()

    fun insert(dataitem: DataItem) = viewModelScope.launch {
        repositry.insert(Articles())
    }

    fun delete(dataitem: DataItem) = viewModelScope.launch {
        repositry.delete(Articles())
    }

    class FavouritesViewModelFactory(private val repositry: FavoRepositry) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(FavouritesViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return FavouritesViewModel(repositry) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}
