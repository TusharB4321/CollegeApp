package com.example.collegeapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.activities.MessageActivity
import com.example.collegeapp.activities.TopicActivity
import com.example.collegeapp.activities.YearActivity
import com.example.collegeapp.databinding.ChatDesignBinding
import com.example.collegeapp.databinding.SampleBranchBinding
import com.example.collegeapp.databinding.SampleLangListBinding
import com.example.collegeapp.models.BranchModel
import com.example.collegeapp.models.ChatModel
import com.example.collegeapp.models.LangTopicModel

class LangTopicAdapter(val context: Context, val list:ArrayList<LangTopicModel>): RecyclerView.Adapter<LangTopicAdapter.ViewHolder>() {
    class ViewHolder(val binding: SampleLangListBinding)
        :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(SampleLangListBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.topic.text=list.get(position).name
        holder.binding.topicImg.setImageResource(list[position].image!!)



        holder.binding.LangTopicLayout.setOnClickListener{

            val intent= Intent(context, TopicActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}