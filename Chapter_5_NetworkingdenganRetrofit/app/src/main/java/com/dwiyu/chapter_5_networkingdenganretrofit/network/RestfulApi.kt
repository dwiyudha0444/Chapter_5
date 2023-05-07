package com.dwiyu.chapter_5_networkingdenganretrofit.network

import com.dwiyu.chapter_5_networkingdenganretrofit.model.DataNews
import com.dwiyu.chapter_5_networkingdenganretrofit.model.ResponseAddNews
import com.dwiyu.chapter_5_networkingdenganretrofit.model.ResponseDataNewsItemItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RestfulApi {
    @GET("news")
    fun getAllNews(): Call<List<ResponseDataNewsItemItem>>

    @POST("news")
    fun postDataNews(@Body request : DataNews) : Call<ResponseAddNews>


}