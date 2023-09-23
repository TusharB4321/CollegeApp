package com.example.collegeapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.collegeapp.activities.MessageActivity
import com.example.collegeapp.activities.YearActivity
import com.example.collegeapp.databinding.ChatDesignBinding
import com.example.collegeapp.databinding.SampleBranchBinding
import com.example.collegeapp.models.BranchModel
import com.example.collegeapp.models.ChatModel

class BranchAdapter(val context: Context, val list:ArrayList<BranchModel>): RecyclerView.Adapter<BranchAdapter.ViewHolder>() {
    class ViewHolder(val binding: SampleBranchBinding)
        :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(SampleBranchBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model=list[position]
        holder.binding.branchName.text=model.name
        Glide.with(context).load(model.image).into(holder.binding.branchImg)

        holder.binding.branchLayout.setOnClickListener{

            val intent= Intent(context, YearActivity::class.java)
            intent.putExtra("name",model.name)
            intent.putExtra("image",model.image)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}