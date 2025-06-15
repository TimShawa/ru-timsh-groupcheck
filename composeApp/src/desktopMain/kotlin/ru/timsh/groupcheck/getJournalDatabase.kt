package ru.timsh.groupcheck

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import ru.timsh.groupcheck.database.JournalDatabase


fun getJournalDatabase(): JournalDatabase {
    val dbFile = "C:/Users/timsh/Documents/GroupCheck/data/journal.db"
    return Room.databaseBuilder<JournalDatabase>(
        name = dbFile
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}