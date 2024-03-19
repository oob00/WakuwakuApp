package com.example.wakuwakuapp.chat

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wakuwakuapp.R
import com.example.wakuwakuapp.api.ApiClient
import com.example.wakuwakuapp.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatActivity: AppCompatActivity() {
    private var rooms: List<Chatroom>? = null

    lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_chatroom_list)

        recyclerView = findViewById(R.id.recyclerView)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val apiService: ApiService = ApiClient(applicationContext).client.create(ApiService::class.java)
        val call: Call<List<Chatroom>> = apiService.getChatroomList()

        call.enqueue(object : Callback<List<Chatroom>> {
            override fun onResponse(call: Call<List<Chatroom>>, response: Response<List<Chatroom>>) {
                rooms = response.body()
                Log.d("채팅방 리스트", rooms.toString())

                val recyclerAdapter = rooms?.let { ChatroomRecyclerAdapter(applicationContext, it) }
                recyclerView.adapter = recyclerAdapter
            }

            override fun onFailure(call: Call<List<Chatroom>>, t: Throwable) {
                Log.d("채팅방 리스트 조회 실패", t.toString())
            }
        })
    }
}