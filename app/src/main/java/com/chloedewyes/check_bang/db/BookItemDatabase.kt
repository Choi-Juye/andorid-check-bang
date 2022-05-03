package com.chloedewyes.check_bang.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chloedewyes.check_bang.models.Item

@Database(
    entities = [Item::class],
    version = 1
)

abstract class BookItemDatabase: RoomDatabase() {

    abstract fun getBookDao(): BookDao

}