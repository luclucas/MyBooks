package com.lulu.mybooks.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LivrosDao {

    @Insert
    suspend fun insertLivro(livro: Livro)

    @Update
    suspend fun updateLivro(livro: Livro)

    @Delete
    suspend fun deleteLivro(livro: Livro)

    @Query("DELETE FROM livros_tbl")
    suspend fun deleteAll()

    @Query("SELECT * FROM livros_tbl")
    fun getLivros(): LiveData<List<Livro>>


}