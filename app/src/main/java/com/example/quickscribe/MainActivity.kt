package com.example.quickscribe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.example.quickscribe.screen.NoteScreen
import com.example.quickscribe.screen.NoteViewModel
import com.example.quickscribe.ui.theme.QuickScribeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuickScribeTheme {
                val noteViewModel: NoteViewModel by viewModels()
                QuickScribeApp(noteViewModel)
            }
        }
    }
}

@Composable
fun QuickScribeApp(noteViewModel: NoteViewModel) {
    val noteList = noteViewModel.noteList.collectAsState().value
    NoteScreen(
        notes = noteList,
        onAddNote = { noteViewModel.addNote(it) },
        onRemoveNote = { noteViewModel.removeNote(it) },
        onRemoveAllNotes = { noteViewModel.removeAllNotes() }
    )
}


@Preview(showSystemUi = true)
@Composable
fun QuickScribePreview() {
    QuickScribeTheme {
        QuickScribeApp(
            noteViewModel = TODO()
        )
    }
}