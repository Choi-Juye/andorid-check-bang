package com.chloedewyes.check_bang.api

import com.chloedewyes.check_bang.BuildConfig.X_Naver_Client_Id
import com.chloedewyes.check_bang.BuildConfig.X_Naver_Client_Secret
import com.chloedewyes.check_bang.models.BookResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NaverAPI {

    @Headers(
        "X-Naver-Client-Id: $X_Naver_Client_Id",
        "X-Naver-Client-Secret: $X_Naver_Client_Secret"
    )

    @GET("v1/search/book.json")
    suspend fun searchForBook(
        @Query("query")
        query: String,
        @Query("display")
        display: Int = 10
    ): Response<BookResponse>

}