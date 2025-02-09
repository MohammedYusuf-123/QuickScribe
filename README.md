# 📝 QuickScribe - Note-Taking App

QuickScribe is a sleek and user-friendly Android app built using Kotlin and Jetpack Compose. It allows users to create, manage, and delete notes with ease. The app showcases modern Android development practices with a clean architecture, intuitive UI, and persistent local storage using Room Database.

---

## 🚀 Features

- **Create Notes**: Add new notes with a title and content.
- **View Notes**: Browse a list of saved notes with real-time updates.
- **Delete Notes**: Remove individual notes by tapping on them.
- **Delete All Notes**: Clear all notes with a single click on the Floating Action Button (FAB).
- **Real-Time UI Updates**: Built using Jetpack Compose with state management for a smooth experience.
- **Persistent Storage**: Notes are saved locally using Room Database, ensuring they persist across app sessions.

---

## 📸 Screenshots

### **Adding a New Note**
<img src="./screenshots/AddingNewNote.png" alt="Adding New Note" width="300"/>

### **Creating a New Note**
<img src="./screenshots/CreatingNewNote.png" alt="Creating New Note" width="300"/>

### **List of Notes**
<img src="./screenshots/NoteList.png" alt="List of Notes" width="300"/>

### **Deleting a Note**
<img src="./screenshots/RemovingNote.png" alt="Removing a Note" width="300"/>

### **Deleting All Notes**
<img src="./screenshots/DeletedAllNotes.png" alt="Deleted All Notes" width="300"/>

---

## 🛠️ Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Local Database**: Room Database
- **Dependency Injection**: Hilt
- **State Management**: StateFlow and MutableStateFlow
- **Material Design 3**: Modern UI components and theming

---

## 📂 Folder Structure

```plaintext
com.example.quickscribe
├── components          # Reusable Jetpack Compose components
├── data                # Room Database setup, DAOs, and mock data
├── di                  # Dependency Injection setup using Hilt
├── model               # Data classes like Note
├── repository          # Repository layer for data management
├── screen              # Composable screens and ViewModel
├── ui.theme            # Custom themes and color definitions
├── util                # Utility classes like DateConverter and UUIDConverter
└── MainActivity.kt     # Entry point for the app
