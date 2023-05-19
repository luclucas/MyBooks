package com.lulu.mybooks.db

class LivroRepository (private val dao: LivrosDao) {

    val livros = dao.getLivros()

    suspend fun insertLivro(livro: Livro){
        dao.insertLivro(livro)
    }

    suspend fun updateLivro(livro: Livro){
        dao.updateLivro(livro)
    }

    suspend fun deleteLivro(livro: Livro){
        dao.deleteLivro(livro)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }

}