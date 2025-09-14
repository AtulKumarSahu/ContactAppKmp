package org.example.contactkmp.data.databasefactory

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import org.example.contactkmp.data.dao.ContactDao
import org.example.contactkmp.data.database.Contact

@Database(
    entities = [Contact::class],
    version = 2
)
@ConstructedBy(DatabaseConstructor::class)
abstract class ContactAppDatabase: RoomDatabase() {
    abstract val dao: ContactDao
    companion object{
        const val DATABASE_NAME = "contact_db"
    }
}