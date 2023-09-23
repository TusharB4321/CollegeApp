package com.example.collegeapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.activities.MessageActivity
import com.example.collegeapp.activities.YearActivity
import com.example.collegeapp.databinding.ChatDesignBinding
import com.example.collegeapp.databinding.SampleBranchBinding
import com.example.collegeapp.databinding.SampleInterviewQuestionBinding
import com.example.collegeapp.models.BranchModel
import com.example.collegeapp.models.ChatModel
import com.example.collegeapp.models.InterviewQuestionModel

class InterviewQuestionAdapter(val context: Context, val list:ArrayList<InterviewQuestionModel>): RecyclerView.Adapter<InterviewQuestionAdapter.ViewHolder>() {
    class ViewHolder(val binding: SampleInterviewQuestionBinding)
        :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(SampleInterviewQuestionBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.interviewQue.text=list.get(position).interviewQue
        holder.binding.number.text=list.get(position).number
        holder.binding.description.text=list.get(position).description
        holder.binding.image.setImageResource(list[position].image!!)



    }

    override fun getItemCount(): Int {
        return list.size
    }
}