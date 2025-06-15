package ru.timsh.groupcheck.database
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

fun getJournalDatabase(): JournalDatabase {
    val dbFile = NSHomeDirectory() + "/journal.db"
    return Room.databaseBuilder<JournalDatabase>(
        name = dbFile,
        factory = { JournalDatabase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}