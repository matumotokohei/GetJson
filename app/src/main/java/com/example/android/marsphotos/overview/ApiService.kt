package com.example.android.marsphotos.overview

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private const val BASE_URL =
     "https://raw.githubusercontent.com/matumotokohei/testJson/master/json/"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface ApiService {

    @GET("sample.json")
    suspend fun getPhotos(): String
}

object MarsApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}