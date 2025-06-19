package ru.timsh.groupcheck.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory


actual var journalDB: JournalDB? = getJournalDB()


fun getJournalDB(): JournalDB {
    val dbFile = NSHomeDirectory() + "/journal.db"
    return Room.databaseBuilder<JournalDB>(
        name = dbFile,
        factory = { JournalDB::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}