package com.example.quickscribe.data

import com.example.quickscribe.model.Note
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date

class NotesDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(
                noteTitle = "Android",
                noteContent = "Open source OS for devices",
                entryDate = Date.from(
                    Instant.now()
                )
            ),
            Note(
                noteTitle = "Kotlin",
                noteContent = "Is first language for Android",
                entryDate = Date.from(
                    Instant.now()
                )
            ),
            Note(
                noteTitle = "MVVM",
                noteContent = "Model-View-View Model is a design patter",
                entryDate = Date.from(
                    Instant.now())
            ),
            Note(
                noteTitle = "ROOM",
                noteContent = "Technology to save data in local database",
                entryDate = Date.from(
                    Instant.now())
            ),
            Note(
                noteTitle = "Jetpack Compose",
                noteContent = "Technology to create UI for Android",
                entryDate = Date.from(
                    Instant.now())
            ),
            Note(
                noteTitle = "Kotlin in Action",
                noteContent = "Best book for learning Kotlin",
                entryDate = Date.from(
                    Instant.now())
            ),
            Note(
                noteTitle = "Java: A Comprehensive Approach",
                noteContent = "Best book for learning Java",
                entryDate = Date.from(
                    Instant.now())
            ),
            Note(
                noteTitle = "Head First: Design Patterns",
                noteContent = "Best book for learning Design patterns",
                entryDate = Date.from(
                    Instant.now())
            ),
        )
    }
}