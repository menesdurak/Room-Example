package com.menesdurak.roomexample.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.menesdurak.roomexample.model.Word

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWord(word: Word)

    @Update
    suspend fun updateWord(word: Word)

    @Query("SELECT * FROM words_table ORDER BY uid ASC")
    fun getAllWords(): LiveData<List<Word>>

    @Delete
    suspend fun deleteWord(word: Word)

    @Query("DELETE FROM words_table")
    suspend fun deleteAllWords()
}