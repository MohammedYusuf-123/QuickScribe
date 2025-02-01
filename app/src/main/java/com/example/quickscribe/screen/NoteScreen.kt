package com.example.quickscribe.screen

import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .displayCutoutPadding()
            .padding(5.dp),
        topBar = {
            Surface {
                TopAppBar(
                    title = { Text(text = "QuickScribe") },
                    colors = TopAppBarDefaults.topAppBarColors(Color.DarkGray)
                )
            }
        }
    ) { innerPadding ->
        Note(Modifier.padding(innerPadding))
    }
}

@Composable
fun Note(modifier: Modifier) {
    Surface(modifier = modifier) {
        Text(text = "Hello There")
    }
}

@Preview(showSystemUi = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}