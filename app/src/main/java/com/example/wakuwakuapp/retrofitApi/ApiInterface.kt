package com.example.wakuwakuapp.retrofitApi

import com.example.wakuwakuapp.chat.Chatroom
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface {
    @Headers("Authorization: eyJhbGciOiJIUzI1NiJ9.eyJzZXEiOjEsImlkIjoiaGVsbG8iLCJuaWNrbmFtZSI6Iu2Zjeq4uOuPmSIsImlhdCI6MTcxMDM4MzU5NSwiZXhwIjoxNzEwMzg3MTk1fQ.SGR29Cw8BuQWPPkWMYA074wgbDXH2Fz1UquvBE8f4eo")
    @GET("chat/rooms")
    fun getChatroomList(): Call<List<Chatroom>>
}