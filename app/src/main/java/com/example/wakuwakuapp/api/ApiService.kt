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
    @Headers("Authorization: eyJhbGciOiJIUzI1NiJ9.eyJzZXEiOjEsImlkIjoiaGVsbG8iLCJuaWNrbmFtZSI6Iu2Zjeq4uOuPmSIsImlhdCI6MTcxMDM4MzU5NSwiZXhwIjoxNzEwMzg3MTk1fQ.SGR29Cw8BuQWPPkWMYA074wgbDXH2Fz1UquvBE8f4eo")
    @GET("chat/rooms")
    fun getChatroomList(): Call<List<Chatroom>>
}