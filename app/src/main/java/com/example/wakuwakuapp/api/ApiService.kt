package com.example.wakuwakuapp.api

import com.example.wakuwakuapp.chat.Chatroom
import com.example.wakuwakuapp.dto.LoginRequest
import com.example.wakuwakuapp.dto.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("/api/auth/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    // chat
    @GET("chat/rooms")
    fun getChatroomList(): Call<List<Chatroom>>
}