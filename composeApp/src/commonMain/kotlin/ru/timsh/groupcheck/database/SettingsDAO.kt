package ru.timsh.groupcheck.database

import androidx.compose.ui.graphics.Color
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.TypeConverters
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
@TypeConverters(TypeConvertersClass::class)
interface SettingsDAO {

    @Upsert(entity = Setting::class)
    suspend fun upsert(entry: Setting)


    @Delete(entity = Setting::class)
    suspend fun delete(entry: Setting)


    @Query("DELETE FROM settings")
    suspend fun deleteAll()


    // Boolean

    @Query("SELECT value_int FROM settings WHERE setting = :setting")
    fun selectValueBoolean(setting: String): Flow<Boolean?>


    @Query("SELECT value_int FROM settings WHERE setting = :setting")
    suspend fun getValueBoolean(setting: String): Boolean?


    @Query("UPDATE settings SET value_int = :value WHERE setting = :setting")
    suspend fun setValueBoolean(setting: String, value: Boolean?)


    // Integer

    @Query("SELECT value_int FROM settings WHERE setting = :setting")
    fun selectValueInt(setting: String): Flow<Int?>


    @Query("SELECT value_int FROM settings WHERE setting = :setting")
    suspend fun getValueInt(setting: String): Int?


    @Query("UPDATE settings SET value_int = :value WHERE setting = :setting")
    suspend fun setValueInt(setting: String, value: Int?)


    // Float

    @Query("SELECT value_real FROM settings WHERE setting = :setting")
    fun selectValueFloat(setting: String): Flow<Float?>


    @Query("SELECT value_real FROM settings WHERE setting = :setting")
    suspend fun getValueFloat(setting: String): Float?


    @Query("UPDATE settings SET value_real = :value WHERE setting = :setting")
    suspend fun setValueFloat(setting: String, value: Float?)


    // String

    @Query("SELECT value_text FROM settings WHERE setting = :setting")
    fun selectValueString(setting: String): Flow<String?>


    @Query("SELECT value_text FROM settings WHERE setting = :setting")
    suspend fun getValueString(setting: String): String?


    @Query("UPDATE settings SET value_text = :value WHERE setting = :setting")
    suspend fun setValueString(setting: String, value: String?)


    // Color
    // FIXME: Conversion STRING -> COLOR (Color.parseColor()) is unavailable

//    @Query("SELECT value_text FROM settings WHERE setting = :setting")
//    fun selectValueColor(setting: String): Flow<Color?>
//
//
//    @Query("SELECT value_text FROM settings WHERE setting = :setting")
//    suspend fun getValueColor(setting: String): Color?
//
//
//    @Query("UPDATE settings SET value_text = :value WHERE setting = :setting")
//    suspend fun setValueColor(setting: String, value: Color?)


    // Color

    @Query("SELECT value_blob FROM settings WHERE setting = :setting")
    fun selectValueBlob(setting: String): Flow<ByteArray?>


    @Query("SELECT value_blob FROM settings WHERE setting = :setting")
    suspend fun getValueBlob(setting: String): ByteArray?


    @Query("UPDATE settings SET value_blob = :value WHERE setting = :setting")
    suspend fun setValueBlob(setting: String, value: ByteArray?)

}