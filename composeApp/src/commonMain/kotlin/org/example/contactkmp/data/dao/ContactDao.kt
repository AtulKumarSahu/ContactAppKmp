package org.example.contactkmp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import org.example.contactkmp.data.database.Contact

@Dao
interface ContactDao {

    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Query("SELECT * FROM Contact")
     fun getContacts(): Flow<List<Contact>>
}