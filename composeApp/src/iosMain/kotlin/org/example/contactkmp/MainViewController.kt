package org.example.contactkmp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import org.example.contactkmp.data.databasefactory.DatabaseFactory

fun MainViewController() = ComposeUIViewController {
    val databuilder = remember { mutableStateOf(DatabaseFactory().createDatabase()) }
    App(databuilder = databuilder.value)
}