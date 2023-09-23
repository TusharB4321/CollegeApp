package com.example.collegeapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.collegeapp.activities.MessageActivity
import com.example.collegeapp.databinding.ChatDesignBinding
import com.example.collegeapp.models.ChatModel
import com.example.collegeapp.models.ProfileModel
import java.net.URI

class ChatAdapter(val context: Context,val list:ArrayList<ProfileModel>): RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    class ViewHolder(val binding: ChatDesignBinding)
        :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ChatDesignBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model=list[position]
        holder.binding.name.text=model.name
        Glide.with(context).load(model.image).into(holder.binding.image)
        holder.binding.branch.text=model.branch
        holder.binding.year.text=model.year
        holder.binding.field.text=model.field



        holder.binding.linearLayout.setOnClickListener{

            val user=list[position]

            val intent= Intent(context, MessageActivity::class.java)
            intent.putExtra("uid",user.uid)
            intent.putExtra("name",user.name)
            intent.putExtra("image",user.image)
            intent.putExtra("field",user.field)
            intent.putExtra("branch",user.branch)
            intent.putExtra("year",user.year)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}