package com.menesdurak.roomexample.view.dictionary

import androidx.lifecycle.*
import com.menesdurak.roomexample.database.WordDao
import com.menesdurak.roomexample.model.Word
import com.menesdurak.roomexample.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel(private val wordDao: WordDao) : ViewModel() {

    private val mutableWordList: MutableLiveData<List<Word>> = MutableLiveData()
    val wordList: LiveData<List<Word>>
        get() = mutableWordList

    fun addWord(word: Word) {
        viewModelScope.launch {
            wordDao.addWord(word)
        }
    }

    fun updateWord(word: Word) {
        viewModelScope.launch {
            wordDao.updateWord(word)
        }
    }

    fun deleteWord(word: Word) {
        viewModelScope.launch {
            wordDao.deleteWord(word)
        }
    }

    fun deleteAllWords() {
        viewModelScope.launch {
            wordDao.deleteAllWords()
        }
    }

    fun getAllWords() {
        viewModelScope.launch {
            mutableWordList.value = wordDao.getAllWords().value
        }
    }
}

class BusScheduleViewModelFactory(
    private val wordDao: WordDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(wordDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}