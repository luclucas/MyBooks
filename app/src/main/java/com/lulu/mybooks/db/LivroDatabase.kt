package com.lulu.mybooks.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Livro::class], version = 1)
abstract class LivroDatabase : RoomDatabase() {

    abstract val livrosDao: LivrosDao

    companion object {
        @Volatile
        private var INSTANCE: LivroDatabase? = null

        fun getInstance(context: Context): LivroDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LivroDatabase::class.java,
                        "livros_db"
                    ).build()
                }
            return instance
            }
        }
    }
}