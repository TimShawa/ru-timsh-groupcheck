package ru.timsh.groupcheck.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface JournalDAO {

    @Upsert(entity = Journal::class)
    suspend fun upsert(entry: Journal)


    @Delete(entity = Journal::class)
    suspend fun delete(entry: Journal)


    @Query("DELETE FROM journal")
    suspend fun clearAll()


    @Query("SELECT * FROM journal")
    fun selectAll(): Flow<List<Journal>>


    @Query("SELECT * FROM journal WHERE date = :date AND subject = :subject")
    fun selectFromDateSubject(date: String, subject: Int): Flow<List<Journal>>


    @Query("SELECT COUNT(*) FROM journal WHERE date = :date AND subject = :subject")
    fun countFromDateSubject(date: String, subject: Int): Flow<Int>


    @Query("SELECT COUNT(*) FROM journal WHERE date = :date AND subject = :subject AND status = 0")
    fun countVisistedFromDateSubject(date: String, subject: Int): Flow<Int>


    @Query("SELECT COUNT(*) FROM journal WHERE date = :date AND subject = :subject AND status = 1")
    fun countMissedFromDateSubject(date: String, subject: Int): Flow<Int>


    @Query("SELECT COUNT(*) FROM journal WHERE date = :date AND subject = :subject AND status = 2")
    fun countPassedDateSubject(date: String, subject: Int): Flow<Int>


    // SUBJECTS

    @Upsert(entity = Subjects::class)
    suspend fun upsertSubject(subject: Subjects)


    @Delete(entity = Subjects::class)
    suspend fun deleteSubject(subject: Subjects)


    @Query("DELETE FROM subjects")
    suspend fun clearAllSubjects()


    @Query("SELECT * FROM subjects")
    fun selectAllSubjects(): Flow<List<Subjects>>


    @Query("SELECT * FROM subjects WHERE date = :date")
    fun selectSubjectsFromDate(date: String): Flow<List<Subjects>>


    @Query("SELECT COUNT(*) FROM subjects WHERE date = :date")
    fun countSubjectFromDate(date: String): Flow<Int>


    @Query("SELECT * FROM subjects WHERE entryID = :subjectID")
    fun selectSubjectFromID(subjectID: Int): Flow<List<Subjects>>

}