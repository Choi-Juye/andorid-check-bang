package com.chloedewyes.check_bang.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chloedewyes.check_bang.db.BookItemDatabase
import com.chloedewyes.check_bang.models.Item
import com.chloedewyes.check_bang.repositories.BookRepository
import kotlinx.coroutines.launch

class BookViewModel(app: Application) : AndroidViewModel(app) {

    val bookDao = BookItemDatabase.invoke(app).getBookDao()
    var bookRepository = BookRepository(bookDao)
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

    fun saveBookItem(bookItem: Item) = viewModelScope.launch {
        bookRepository.upsert(bookItem)
    }

    fun getSavedBookItem() = bookRepository.getSavedBookItem()


    fun deleteBookItem(bookItem: Item) = viewModelScope.launch {
        bookRepository.delete(bookItem)
    }


}

