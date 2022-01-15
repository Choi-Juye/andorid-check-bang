package com.chloedewyes.check_bang.models

data class Item(
    var id: Int? = null,
    val title: String,
    val author: String,
    val publisher: String,
    val pubdate: String
)
