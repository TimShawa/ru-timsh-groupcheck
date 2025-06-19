package ru.timsh.groupcheck.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver


actual var settingsDB: SettingsDB? = null


fun getSettingsDB(context: Context): SettingsDB {
    val dbFile = context.getDatabasePath("settings.db")
    return Room.databaseBuilder<SettingsDB>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .fallbackToDestructiveMigrationOnDowngrade(true)
        .build()
}