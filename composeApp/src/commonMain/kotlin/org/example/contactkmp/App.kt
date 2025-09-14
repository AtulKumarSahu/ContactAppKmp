package org.example.contactkmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import contactappkmp.composeapp.generated.resources.Res
import contactappkmp.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.example.contactkmp.data.database.Contact
import org.example.contactkmp.data.databasefactory.ContactAppDatabase

@Composable
@Preview
fun App(databuilder: RoomDatabase.Builder<ContactAppDatabase>) {
    MaterialTheme {
        val db = dbbuilder(databuilder)
        val scope = rememberCoroutineScope()

        val contact = Contact(
            firstName = "John",
            lastName = "Doe",
            phoneNumber = "1234567890",
            email = "john@gmail.com",
            favorite = true,
        )

        var contacts by remember { mutableStateOf(emptyList<Contact>()) }
        var loading by remember { mutableStateOf(false) }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                scope.launch {
                    db.dao.upsertContact(contact = contact)
                }
            }) {
                Text("Add Contact")
            }

            Button(onClick = {
                loading = true
                scope.launch {
                    db.dao.getContacts().collectLatest {
                        contacts = it
                        loading = false
                    }
                }
            }) {
                Text("Show Contacts")
            }

            if (loading) {
                CircularProgressIndicator()
            }

            LazyColumn {
                items(contacts) {
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column {
                            Text(it.firstName)
                            Text(it.lastName)
                            Text(it.phoneNumber)
                            Text(it.email)
                        }
                    }
                }
            }
        }
    }
}

fun dbbuilder(roomDatabaseBuilder: RoomDatabase.Builder<ContactAppDatabase>): ContactAppDatabase {
    return roomDatabaseBuilder
        .setDriver(BundledSQLiteDriver())
        .fallbackToDestructiveMigration(true)
        .build()
}
