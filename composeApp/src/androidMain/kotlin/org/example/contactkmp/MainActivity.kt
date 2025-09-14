package org.example.contactkmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import org.example.contactkmp.data.databasefactory.DatabaseFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val  databuilder = remember { mutableStateOf(DatabaseFactory(applicationContext).createDatabase()) }
            App(databuilder = databuilder.value)
        }
    }
}

