package com.lulu.mybooks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lulu.mybooks.db.LivroRepository

class LivroViewModelFactory (private val repository: LivroRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LivroViewModel::class.java)) {
            return LivroViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown view model class")
    }
}
