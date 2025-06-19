package ru.timsh.groupcheck.database

import androidx.compose.ui.graphics.Color
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter


@Entity(tableName = "settings")
class Setting(
    @PrimaryKey
    val setting: String,

    @ColumnInfo(name = "value_int")
    val valueInt: Int? = null,

    @ColumnInfo(name = "value_real")
    val valueReal: Float? = null,

    @ColumnInfo(name = "value_text")
    val valueText: String? = null,

    @ColumnInfo(name = "value_blob")
    val valueBlob: ByteArray? = null

)


class TypeConvertersClass {
    @TypeConverter
    fun fromColorToHex(color: Color?): String? {
        return null // FIXME
    }

    @TypeConverter
    fun fromHexToColor(hex: String?): Color? {
        return null // FIXME
    }
}























