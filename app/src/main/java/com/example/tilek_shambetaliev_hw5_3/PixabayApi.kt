package com.example.tilek_shambetaliev_hw5_3

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {
    @GET("api/")
    fun getImages(
        @Query("q") searhc: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 3,
        @Query("key") key: String = "35820127-6faa0d458e1747c282a53c235"
    ): Call<PixaModel>


}