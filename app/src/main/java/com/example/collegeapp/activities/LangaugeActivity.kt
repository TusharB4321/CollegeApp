package com.example.collegeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.collegeapp.R
import com.example.collegeapp.adapters.LangAdapter
import com.example.collegeapp.adapters.LangTopicAdapter
import com.example.collegeapp.databinding.ActivityLangaugeBinding
import com.example.collegeapp.models.LangTopicModel

class LangaugeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLangaugeBinding
    private lateinit var list: ArrayList<LangTopicModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLangaugeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        list= ArrayList()
        list.add(LangTopicModel(R.drawable.it,"Topic Name"))
        list.add(LangTopicModel(R.drawable.it,"Topic Name"))
        list.add(LangTopicModel(R.drawable.it,"Topic Name"))
        list.add(LangTopicModel(R.drawable.it,"Topic Name"))
        list.add(LangTopicModel(R.drawable.it,"Topic Name"))
        list.add(LangTopicModel(R.drawable.it,"Topic Name"))
        list.add(LangTopicModel(R.drawable.it,"Topic Name"))
        list.add(LangTopicModel(R.drawable.it,"Topic Name"))


        binding.langRecycler.adapter=LangTopicAdapter(this,list)
        binding.langRecycler.layoutManager=LinearLayoutManager(this)


    }
}