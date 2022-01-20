package com.chloedewyes.check_bang.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.chloedewyes.check_bang.models.Item

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(bookItem: Item): Long

    @Query("SELECT * FROM bookItems")
    fun getAllItem(): LiveData<List<Item>>

    @Delete
    suspend fun deleteItem(bookItem: Item)

}