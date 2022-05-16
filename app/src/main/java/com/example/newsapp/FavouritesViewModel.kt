package com.example.newsapp

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class FavouritesViewModel( val repositry: FavoRepositry) : ViewModel() {

    var allfavo: LiveData<List<Articles>> = repositry.allfavlist

    fun addfavo(dataitem: Articles) = viewModelScope.launch {
        repositry.insert(Articles())
    }
    fun deletefavo(dataitem: Articles) = viewModelScope.launch {
        repositry.delete(Articles())
    }
    //fun showfavo(dataitem: Articles)= viewModelScope.launch {
    //    repositry.getdata()
    //}

    class FavouritesViewModelFactory(val repositry: FavoRepositry) :
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
