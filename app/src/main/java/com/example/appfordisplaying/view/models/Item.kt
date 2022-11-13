package com.example.appfordisplaying.view.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "items_information")
@JsonClass(generateAdapter = true)
data class Item(
    @ColumnInfo(name = "title")
    @Json(name = "title")
    val title: String = "",
    @ColumnInfo(name = "url")
    @Json(name = "url")
    val url: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    @Json(name = "id")
    var id: Int = 0
}