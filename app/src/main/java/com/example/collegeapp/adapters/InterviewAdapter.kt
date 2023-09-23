package com.example.collegeapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.collegeapp.activities.InterviewActivity
import com.example.collegeapp.activities.MessageActivity
import com.example.collegeapp.databinding.ChatDesignBinding
import com.example.collegeapp.databinding.SampleInterviewBinding
import com.example.collegeapp.models.ChatModel
import com.example.collegeapp.models.InterviewModel

class InterviewAdapter(val context: Context, val list:ArrayList<InterviewModel>): RecyclerView.Adapter<InterviewAdapter.ViewHolder>() {
    class ViewHolder(val binding: SampleInterviewBinding)
        :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(SampleInterviewBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model=list[position]
        Glide.with(context).load(model.image).into(holder.binding.interviewImg)



        holder.binding.layout.setOnClickListener{

            val intent= Intent(context, InterviewActivity::class.java)

            intent.putExtra("image",model.image)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}