package ru.timsh.groupcheck.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "subjects_data")
class DateEntry(
    @PrimaryKey(autoGenerate = true) val subjDataID: Int = 0,
    val subjectName: String,
    val beginTime: Int = 830, // [hmm] format
    val endTime: Int = 1000,
    val checkVisited: Int = 0,
    val checkLate: Int = 0, // Can be displayed or not
    val checkMissed: Int = 0,
    val checkReasonable: Int = 0,
)