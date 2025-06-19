package ru.timsh.groupcheck.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Journal(
    val date: String,
    val subject: Int,
    val student: String,
    val status: Int = 0,
    val mark: Int? = null,
    @PrimaryKey(autoGenerate = true) val entryID: Int = 0
)