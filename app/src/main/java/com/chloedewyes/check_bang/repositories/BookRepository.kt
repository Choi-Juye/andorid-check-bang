package com.chloedewyes.check_bang.repositories

import com.chloedewyes.check_bang.api.RetrofitBuilder

class BookRepository {

    suspend fun searchBook(searchQuery: String, displayNumber: Int) =
        RetrofitBuilder.api.searchForBook(searchQuery, displayNumber)
}