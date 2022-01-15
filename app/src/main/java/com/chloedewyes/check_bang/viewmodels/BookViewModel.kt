package com.chloedewyes.check_bang.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chloedewyes.check_bang.models.BookResponse
import com.chloedewyes.check_bang.repositories.BookRepository
import kotlinx.coroutines.launch

class BookViewModel: ViewModel() {
    var bookRepository = BookRepository()

    val searchBook: MutableLiveData<BookResponse> = MutableLiveData()
    var searchBookDisplay = 10

    fun searchBook(searchQuery: String) = viewModelScope.launch {
        val response = bookRepository.searchBook(searchQuery, searchBookDisplay)
        Log.d("test", "response : $response")
    }


}