package com.chloedewyes.check_bang.repositories

import android.app.Application
import android.content.Context
import com.chloedewyes.check_bang.api.RetrofitBuilder
import com.chloedewyes.check_bang.db.BookDao
import com.chloedewyes.check_bang.db.BookItemDatabase

import com.chloedewyes.check_bang.models.Item
import javax.inject.Inject

class BookRepository @Inject constructor(val bookDao: BookDao) {

    suspend fun searchBook(searchQuery: String, displayNumber: Int) =
        RetrofitBuilder.api.searchForBook(searchQuery, displayNumber)

    suspend fun upsert(bookItem: Item) = bookDao.upsert(bookItem)

    fun getSavedBookItem() = bookDao.getAllItem()

    suspend fun delete(bookItem: Item) = bookDao.deleteItem(bookItem)
}