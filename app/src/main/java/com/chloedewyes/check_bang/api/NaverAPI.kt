package com.chloedewyes.check_bang.api

import com.chloedewyes.check_bang.BuildConfig.clientId
import com.chloedewyes.check_bang.BuildConfig.clientSecret
import com.chloedewyes.check_bang.models.BookResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NaverAPI {

    @Headers(
        "X-Naver-Client-Id:$clientId",
        "X-Naver-Client-Secret:$clientSecret"
    )

    @GET("v1/search/book.json")
    suspend fun searchForBook(
        @Query("query")
        query: String,
        @Query("display")
        display: Int = 10
    ): Response<BookResponse>

}