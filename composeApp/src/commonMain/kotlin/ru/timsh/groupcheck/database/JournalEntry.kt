package ru.timsh.groupcheck.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "journal")
class JournalEntry(
    @PrimaryKey(autoGenerate = true) val entryID: Int = 0,
    val date: String,
    val subject: String?,
    val group: String?,
    val student: String,
    val mark: String?,
    val comment: String?
)