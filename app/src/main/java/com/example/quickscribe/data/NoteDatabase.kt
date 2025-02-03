package com.example.quickscribe.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.quickscribe.model.DateConverter
import com.example.quickscribe.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}