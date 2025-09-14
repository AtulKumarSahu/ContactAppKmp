package org.example.contactkmp.data.databasefactory

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

actual class DatabaseFactory(var ctx:Context) {
    actual fun createDatabase(): RoomDatabase.Builder<ContactAppDatabase> {
        val appContext = ctx.applicationContext
        val dbFile = appContext.getDatabasePath(ContactAppDatabase.DATABASE_NAME)
        return Room.databaseBuilder<ContactAppDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        )
    }

}