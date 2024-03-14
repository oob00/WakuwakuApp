package com.example.wakuwakuapp.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wakuwakuapp.R

class ChatroomRecyclerAdapter(
    private val c: Context,
    private val dataList: List<Chatroom>): RecyclerView.Adapter<ChatroomRecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(c).inflate(R.layout.list_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = dataList[position]
        holder.roomName.text = data.roomName
        holder.userCount.text = data.userCount.toString()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val roomName: TextView = itemView.findViewById(R.id.roomName)
        val userCount: TextView = itemView.findViewById(R.id.userCount)
    }
}