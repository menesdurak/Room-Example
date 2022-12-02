package com.menesdurak.roomexample.view

import android.app.Application
import com.menesdurak.roomexample.database.WordDatabase

class WordApplication : Application() {
    val database: WordDatabase by lazy { WordDatabase.getDatabase(this) }
}