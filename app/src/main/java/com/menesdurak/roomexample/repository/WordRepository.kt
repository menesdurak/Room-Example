package com.menesdurak.roomexample.repository

import androidx.lifecycle.LiveData
import com.menesdurak.roomexample.database.WordDao
import com.menesdurak.roomexample.model.Word

class WordRepository(private val wordDao: WordDao) {

    suspend fun addWord(word: Word) {
        wordDao.addWord(word)
    }

    suspend fun updateWord(word: Word) {
        wordDao.updateWord(word)
    }

    suspend fun deleteWord(word: Word) {
        wordDao.deleteWord(word)
    }

    suspend fun deleteAllWords() {
        wordDao.deleteAllWords()
    }

    fun getAllWords(): LiveData<List<Word>> = wordDao.getAllWords()
}