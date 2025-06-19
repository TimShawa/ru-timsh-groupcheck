package ru.timsh.groupcheck.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Subjects(
    val date: String,
    val dailyIndex: Int,
    val subjectName: String,
    val beginTime: Int,
    val endTime: Int,
    @PrimaryKey(autoGenerate = true) val entryID: Int = 0
)