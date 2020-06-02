package com.example.retrofit_sample

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
//Service

interface GetData {
    @GET("/users")
    suspend fun getAllUsers(): Response<List<RetroUsers>>

}