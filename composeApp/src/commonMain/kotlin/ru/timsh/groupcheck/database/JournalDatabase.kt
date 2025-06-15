package ru.timsh.groupcheck.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [JournalEntry::class],
    version = 1
)
abstract class JournalDatabase: RoomDatabase() {

    abstract fun journalDao(): JournalDao

}