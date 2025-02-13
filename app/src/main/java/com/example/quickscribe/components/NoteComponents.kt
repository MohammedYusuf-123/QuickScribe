package com.example.quickscribe.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.example.quickscribe.model.Note
import com.example.quickscribe.util.formatDate

@Composable
fun NoteInputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onTextChanged: (String) -> Unit,
    onImeAction: @Composable () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = text,
        onValueChange = onTextChanged,
        label = { Text(text = label) },
        maxLines = maxLine,
        keyboardOptions = keyboardOptions,
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
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit
) {
    val context = LocalContext.current
    Surface(
        modifier = modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(16.dp))
            .fillMaxWidth(),
        color = Color(0xFFDFE6EB),
        shadowElevation = 6.dp
    ) {
        Column(
            modifier = modifier
                .clickable {
                    onNoteClicked(note)
                    Toast.makeText(context, "Note removed", Toast.LENGTH_SHORT).show()
                }
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = note.noteTitle, style = MaterialTheme.typography.bodyMedium)
            Text(text = note.noteContent, style = MaterialTheme.typography.bodyLarge)
            Text(
                text = formatDate(note.entryDate.time),
                style = MaterialTheme.typography.bodySmall
            )
        }

    }
}