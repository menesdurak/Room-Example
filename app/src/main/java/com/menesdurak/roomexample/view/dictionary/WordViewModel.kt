package com.menesdurak.roomexample.view.dictionary

import androidx.lifecycle.*
import com.menesdurak.roomexample.database.WordDao
import com.menesdurak.roomexample.model.Word
import com.menesdurak.roomexample.repository.WordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository) : ViewModel() {

    val wordlist: LiveData<List<Word>> = repository.getAllWords()

    fun addWord(word: Word) {
        viewModelScope.launch {
            repository.addWord(word)
        }
    }

    fun updateWord(word: Word) {
        viewModelScope.launch {
            repository.updateWord(word)
        }
    }

    fun deleteWord(word: Word) {
        viewModelScope.launch {
            repository.deleteWord(word)
        }
    }

    fun deleteAllWords() {
        viewModelScope.launch {
            repository.deleteAllWords()
        }
    }

}