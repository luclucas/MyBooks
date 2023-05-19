package com.lulu.mybooks.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "livros_tbl")
data class Livro(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "livro_id")
    val id: Long,

    @ColumnInfo(name = "titulo")
    var titulo: String?,

    @ColumnInfo(name = "autor")
    var autor: String?,

    @ColumnInfo(name = "lido")
    var lido: Boolean,

    @ColumnInfo(name = "anotacao")
    var anotacoes: String?
        )