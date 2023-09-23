package com.example.collegeapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.collegeapp.activities.CourseActivity
import com.example.collegeapp.activities.MessageActivity
import com.example.collegeapp.databinding.ChatDesignBinding
import com.example.collegeapp.databinding.LanglayoutBinding
import com.example.collegeapp.databinding.SampleCoursesBinding
import com.example.collegeapp.models.ChatModel
import com.example.collegeapp.models.CourseModel

class CourseAdapter(val context: Context, val list:ArrayList<CourseModel>): RecyclerView.Adapter<CourseAdapter.ViewHolder>() {
    class ViewHolder(val binding: SampleCoursesBinding)
        :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(SampleCoursesBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model = list[position]
        holder.binding.description.text = model.descreption
        Glide.with(context).load(model.courseImage).into(holder.binding.courseImage)
        holder.binding.development.text = model.courseName


        holder.binding.linearLayout.setOnClickListener{

            val intent= Intent(context, CourseActivity::class.java)
//            intent.putExtra("name",model.courseName)
//            intent.putExtra("des",model.descreption)
//            intent.putExtra("image",model.courseImage)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}