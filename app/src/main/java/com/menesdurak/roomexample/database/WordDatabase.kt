package com.menesdurak.roomexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.menesdurak.roomexample.model.Word

@Database(entities = arrayOf(Word::class), version = 1, exportSchema = false)
abstract class WordDatabase: RoomDatabase() {

    abstract fun getWordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: WordDatabase? = null

        fun getDatabase(context: Context): WordDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordDatabase::class.java,
                    "words_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }

}