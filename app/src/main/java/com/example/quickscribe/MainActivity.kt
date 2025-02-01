package com.example.quickscribe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.quickscribe.screen.NoteScreen
import com.example.quickscribe.ui.theme.QuickScribeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuickScribeTheme {
                QuickScribeApp()
            }
        }
    }
}

@Composable
fun QuickScribeApp() {
    NoteScreen()
}


@Preview(showBackground = true)
@Composable
fun QuickScribePreview() {
    QuickScribeTheme {
        QuickScribeApp()
    }
}