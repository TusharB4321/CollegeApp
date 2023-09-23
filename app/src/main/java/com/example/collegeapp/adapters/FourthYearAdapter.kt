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
import com.example.collegeapp.databinding.SampleFirstyearBinding
import com.example.collegeapp.models.*

class FourthYearAdapter(val context: Context, val list:ArrayList<FourthYearModel>): RecyclerView.Adapter<FourthYearAdapter.ViewHolder>() {
    class ViewHolder(val binding:SampleFirstyearBinding)
        :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(SampleFirstyearBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.subject.text=list.get(position).subject
        holder.binding.time.text=list.get(position).time
        holder.binding.bookImage.setImageResource(list[position].bookImage!!)
        holder.binding.img.setImageResource(list[position].image!!)



//        holder.binding.firstYearLayout.setOnClickListener{
//
//            val intent= Intent(context, MessageActivity::class.java)
//            context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}