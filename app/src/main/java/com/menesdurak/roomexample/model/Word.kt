package com.menesdurak.roomexample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
data class Word (
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "meaning")
    val meaning: String
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}