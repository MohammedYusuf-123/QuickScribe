package com.example.quickscribe.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun NoteInputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChanged: (String) -> Unit,
    onImeAction: () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = text,
        onValueChange = onTextChanged,
        label = { Text(text = label) },
        maxLines = maxLine,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction
            keyboardController?.hide()
        }),
        modifier = modifier,
        shape = TextFieldDefaults.shape,
        colors = TextFieldDefaults.colors(Color.Black)
    )
}

@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    buttonName: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        modifier = modifier
    ) {
        Text(text = buttonName)
    }
}

@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    noteTitle: String,
    noteContent: String
) {
    Card(
        modifier = modifier,
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Text(text = noteTitle)
        Text(text = noteContent)
    }
}