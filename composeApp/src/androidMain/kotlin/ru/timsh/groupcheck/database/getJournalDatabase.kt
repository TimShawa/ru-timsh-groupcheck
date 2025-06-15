package ru.timsh.groupcheck.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver


fun getJournalDatabase(context: Context): JournalDatabase {
    val dbFile = context.getDatabasePath("journal.db")
    return Room.databaseBuilder<JournalDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath,
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}