package ru.timsh.groupcheck.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver


actual var journalDB: JournalDB? = null


fun getJournalDB(context: Context): JournalDB {
    val dbPath = context.getDatabasePath("journal.db")
    return Room.databaseBuilder<JournalDB>(
        context = context.applicationContext,
        name = dbPath.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}