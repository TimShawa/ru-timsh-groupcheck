package ru.timsh.groupcheck.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [Setting::class],
    version = 3
)
abstract class SettingsDB: RoomDatabase() {
    abstract fun getDAO(): SettingsDAO
}


expect var settingsDB: SettingsDB?

var settingsDAO: SettingsDAO = settingsDB!!.getDAO()