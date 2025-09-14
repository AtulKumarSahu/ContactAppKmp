package org.example.contactkmp.data.databasefactory

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object DatabaseConstructor: RoomDatabaseConstructor<ContactAppDatabase> {
    override fun initialize(): ContactAppDatabase
}