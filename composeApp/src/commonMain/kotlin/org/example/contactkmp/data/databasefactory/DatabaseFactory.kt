package org.example.contactkmp.data.databasefactory

import androidx.room.RoomDatabase

expect class DatabaseFactory{
     fun createDatabase(): RoomDatabase.Builder<ContactAppDatabase>
}





