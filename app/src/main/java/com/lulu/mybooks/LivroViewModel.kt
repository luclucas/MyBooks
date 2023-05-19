package com.lulu.mybooks

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lulu.mybooks.db.Livro
import com.lulu.mybooks.db.LivroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LivroViewModel(private val repository: LivroRepository): ViewModel() {

    val livros = repository.livros

    val inputTitulo = MutableLiveData<String>()
    val inputAutor = MutableLiveData<String>()
    val inputLido = MutableLiveData<Boolean>()
    val inputAnotacao = MutableLiveData<String>()

    fun save(){

            val titulo = inputTitulo.value.toString()
            val autor = inputAutor.value.toString()
            val lido = inputLido.value
            val anotacao = inputAnotacao.value.toString()

            insert(Livro(0, titulo, autor, lido == false, anotacao))
    }

    fun insert(livro: Livro){
        viewModelScope.launch (Dispatchers.IO){
            repository.insertLivro(livro)

        }
    }

    fun deleteAll(){
        viewModelScope.launch (Dispatchers.IO) {
            repository.deleteAll()
        }
    }

}