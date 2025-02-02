package com.example.quickscribe.model

import java.time.LocalDateTime
import java.util.UUID

data class Note(
    val id: UUID = UUID.randomUUID(),
    val noteTitle: String,
    val noteContent: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
