package com.chloedewyes.check_bang.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "bookItems"
)
data class Item(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val image: String?,
    val title: String?,
    val author: String?,
    val publisher: String?,
    val pubdate: String?
) : Serializable
