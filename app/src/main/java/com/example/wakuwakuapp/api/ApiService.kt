package com.example.wakuwakuapp.api

import com.example.wakuwakuapp.dto.LoginRequest
import com.example.wakuwakuapp.dto.LoginResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST("/api/auth/login")
    fun login( @Body request: LoginRequest ): Call<LoginResponse>
}