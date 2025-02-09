package com.example.quickscribe.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quickscribe.R
import com.example.quickscribe.components.NoteButton
import com.example.quickscribe.components.NoteInputText
import com.example.quickscribe.components.NoteRow
import com.example.quickscribe.data.NotesDataSource
import com.example.quickscribe.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit,
    onRemoveAllNotes: () -> Unit
) {
    val noteName = remember {
        mutableStateOf("")
    }
    val noteContent = remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                actions = {
                    Icon(
                        imageVector = Icons.Rounded.Notifications,
                        contentDescription = "Icon",
                        tint = Color.Black
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(Color(0xFFDADFE3))
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onRemoveAllNotes()
                    Toast.makeText(context, "Deleted all", Toast.LENGTH_SHORT).show()
                },
                containerColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete All Notes",
                    tint = Color.Red
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(6.dp)
        ) {

            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NoteInputText(
                    text = noteName.value,
                    label = "Title",
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                    onTextChanged = {
                        if (it.all { char ->
                                char.isLetter() || char.isWhitespace()
                            })
                            noteName.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(top = 9.dp, bottom = 8.dp)
                )
                Spacer(modifier = Modifier.height(6.dp))
                NoteInputText(
                    text = noteContent.value,
                    label = "Add a note",
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    onTextChanged = {
                        if (it.all { char ->
                                char.isLetter() || char.isWhitespace() || char.isDigit()
                            })
                            noteContent.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(top = 9.dp, bottom = 8.dp)
                )
                Spacer(modifier = Modifier.height(6.dp))
                NoteButton(
                    buttonName = "Save",
                    onClick = {
                        if (noteName.value.isNotEmpty() && noteContent.value.isNotEmpty()) {
                            onAddNote(
                                Note(
                                    noteTitle = noteName.value,
                                    noteContent = noteContent.value
                                )
                            )
                            Toast.makeText(context, "Note added", Toast.LENGTH_SHORT).show()
                            noteName.value = ""
                            noteContent.value = ""
                        }
                    }
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .padding(10.dp)
                    .shadow(elevation = 3.dp),
                thickness = 2.dp
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(notes) { note ->
//                    NoteCard(modifier = Modifier.fillMaxWidth(), noteTitle = note.noteTitle, noteContent = note.noteContent)
                    NoteRow(note = note, onNoteClicked = { onRemoveNote(note) })
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(
        notes = NotesDataSource().loadNotes(),
        onAddNote = {},
        onRemoveNote = {},
        onRemoveAllNotes = {})
}