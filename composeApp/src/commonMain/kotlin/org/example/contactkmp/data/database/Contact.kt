package org.example.contactkmp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Long?=null,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val favorite: Boolean,

)
