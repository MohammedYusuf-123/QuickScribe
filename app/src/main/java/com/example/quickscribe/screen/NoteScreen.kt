package com.example.quickscribe.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quickscribe.R
import com.example.quickscribe.components.NoteButton
import com.example.quickscribe.components.NoteInputText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen() {
    val noteName = remember {
        mutableStateOf("")
    }
    val noteContent = remember {
        mutableStateOf("")
    }
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
                    onTextChanged = {
                        if (it.all { char ->
                                char.isLetter() || char.isWhitespace()
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
                        if (noteName.value.isNotEmpty() && noteContent.value.isNotEmpty()){
                            //save/add the  content to the list
                        }
                    }
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn {
//                    NoteCard(noteTitle = noteName.value, noteContent = noteContent.value)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}