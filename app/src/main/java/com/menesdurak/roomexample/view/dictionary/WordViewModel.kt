package com.menesdurak.roomexample.view.dictionary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.menesdurak.roomexample.model.Word
import com.menesdurak.roomexample.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository) : ViewModel() {

    private val mutableWordList: MutableLiveData<List<Word>> = MutableLiveData()
    val wordList: LiveData<List<Word>>
        get() = mutableWordList

    fun insertWord(word: Word) {
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

    fun getAllWords() {
        viewModelScope.launch {
            mutableWordList.value = repository.getAllWords().value
        }
    }
}