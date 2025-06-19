package ru.timsh.groupcheck.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [
        Journal::class,
        Subjects::class
    ],
    version = 1
)
abstract class JournalDB: RoomDatabase() {

    abstract fun getDAO(): JournalDAO

}


expect var journalDB: JournalDB?

var journalDAO: JournalDAO = journalDB!!.getDAO()