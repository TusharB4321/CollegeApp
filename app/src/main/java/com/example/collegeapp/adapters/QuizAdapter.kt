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
import com.example.collegeapp.databinding.SampleQuizBinding
import com.example.collegeapp.models.BranchModel
import com.example.collegeapp.models.ChatModel
import com.example.collegeapp.models.QuizModel

class QuizAdapter(val context: Context, val list:ArrayList<QuizModel>): RecyclerView.Adapter<QuizAdapter.ViewHolder>() {
    class ViewHolder(val binding: SampleQuizBinding)
        :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(SampleQuizBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.name.text=list.get(position).name
        holder.binding.question.text=list.get(position).questions
        holder.binding.image.setImageResource(list[position].image!!)



//        holder.binding.quizLayout.setOnClickListener{
//
//            val intent= Intent(context, MessageActivity::class.java)
//            context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}