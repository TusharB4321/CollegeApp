package com.example.collegeapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.collegeapp.activities.LangaugeActivity
import com.example.collegeapp.activities.MessageActivity
import com.example.collegeapp.databinding.ChatDesignBinding
import com.example.collegeapp.databinding.LanglayoutBinding
import com.example.collegeapp.models.ChatModel
import com.example.collegeapp.models.LangModel

class LangAdapter(val context: Context, val list:ArrayList<LangModel>): RecyclerView.Adapter<LangAdapter.ViewHolder>() {
    class ViewHolder(val binding: LanglayoutBinding)
        :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LanglayoutBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model=list[position]
        holder.binding.lang.text=model.name
        Glide.with(context).load(model.image).into(holder.binding.img)



        holder.binding.linearLayout.setOnClickListener{

            val intent= Intent(context, LangaugeActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}