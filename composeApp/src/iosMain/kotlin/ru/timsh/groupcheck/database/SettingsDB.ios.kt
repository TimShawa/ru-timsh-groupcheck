package ru.timsh.groupcheck.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory


actual var settingsDB: SettingsDB? = getSettingsDB()


fun getSettingsDB(): SettingsDB {
    val dbFile = NSHomeDirectory() + "/settings.db"
    return Room.databaseBuilder<SettingsDB>(
        name = dbFile,
        factory = { SettingsDB::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .fallbackToDestructiveMigrationOnDowngrade(true)
        .build()
}