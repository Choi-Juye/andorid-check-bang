package com.chloedewyes.check_bang.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chloedewyes.check_bang.models.BookResponse
import com.chloedewyes.check_bang.models.Item
import com.chloedewyes.check_bang.repositories.BookRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class BookViewModel : ViewModel() {
    var bookRepository = BookRepository()

    val bookItem: MutableLiveData<List<Item>> = MutableLiveData()
    var searchBookDisplay = 10

    fun searchBook(searchQuery: String) = viewModelScope.launch {
        val response = bookRepository.searchBook(searchQuery, searchBookDisplay)
        response.body()?.let { resultResponse ->
            if (response.isSuccessful) {
                bookItem.postValue(resultResponse.items)
            }

        }
    }

}

