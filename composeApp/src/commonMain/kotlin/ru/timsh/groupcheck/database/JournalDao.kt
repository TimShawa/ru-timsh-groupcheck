package ru.timsh.groupcheck.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface JournalDao {

    @Upsert
    suspend fun upsert(entry: JournalEntry)

    @Delete
    suspend fun delete(entry: JournalEntry)

    @Query("SELECT * FROM journal")
    fun getAllEntries(): Flow<List<JournalEntry>>

    @Query("SELECT * FROM journal WHERE date LIKE :date")
    fun getSubjectsByDate()

}