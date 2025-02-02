package com.example.quickscribe.data

import com.example.quickscribe.model.Note
import java.time.LocalDateTime

class NotesDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(noteTitle = "Android", noteContent = "Open source OS for devices", entryDate = LocalDateTime.now()),
            Note(noteTitle = "Kotlin", noteContent = "Is first language for Android", entryDate = LocalDateTime.now()),
            Note(noteTitle = "MVVM", noteContent = "Model-View-View Model is a design patter", entryDate = LocalDateTime.now()),
            Note(noteTitle = "ROOM", noteContent = "Technology to save data in local database", entryDate = LocalDateTime.now()),
            Note(noteTitle = "Jetpack Compose", noteContent = "Technology to create UI for Android", entryDate = LocalDateTime.now()),
            Note(noteTitle = "Kotlin in Action", noteContent = "Best book for learning Kotlin", entryDate = LocalDateTime.now()),
            Note(noteTitle = "Java: A Comprehensive Approach", noteContent = "Best book for learning Java", entryDate = LocalDateTime.now()),
            Note(noteTitle = "Head First: Design Patterns", noteContent = "Best book for learning Design patterns", entryDate = LocalDateTime.now()),
        )
    }
}