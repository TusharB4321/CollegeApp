package com.example.collegeapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.databinding.ReceiverItemLayoutBinding
import com.example.collegeapp.databinding.SentItemLayoutBinding
import com.example.collegeapp.models.MessageModel
import com.google.firebase.auth.FirebaseAuth

class MessageAdapter(var context:Context,var list:ArrayList<MessageModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var ITEM_SENT=1
    var ITEM_RECEIVE=2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return if (viewType==ITEM_SENT)
           SentViewHolder(LayoutInflater.from(context).inflate(R.layout.sent_item_layout,parent,false))
        else
           ReceiveViewHolder(LayoutInflater.from(context).inflate(R.layout.receiver_item_layout,parent,false))
    }

    override fun getItemViewType(position: Int): Int {
        return if (FirebaseAuth.getInstance().uid==list[position].senderId) ITEM_SENT else ITEM_RECEIVE

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var message=list[position]
        if (holder.itemViewType==ITEM_SENT){

            val viewHolder=holder as
                    SentViewHolder

            viewHolder.binding.sentMessage.text=message.message
        }
        else{

            val viewHolder=holder as
                    ReceiveViewHolder
            viewHolder.binding.receiveMessage.text=message.message



        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class SentViewHolder(view:View):RecyclerView.ViewHolder(view){

        val binding= SentItemLayoutBinding.bind(view)

    }

    inner class ReceiveViewHolder(view:View):RecyclerView.ViewHolder(view){
        val binding= ReceiverItemLayoutBinding.bind(view)



    }
}