package com.example.collegeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.collegeapp.R
import com.example.collegeapp.adapters.QuizAdapter
import com.example.collegeapp.databinding.ActivityQuizeBinding
import com.example.collegeapp.models.QuizModel

class QuizeActivity : AppCompatActivity() {

    private lateinit var binding:ActivityQuizeBinding
    private lateinit var list:ArrayList<QuizModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityQuizeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        list= ArrayList()

        list.add(QuizModel(R.drawable.quize,"Android Development","25 Questions"))
        list.add(QuizModel(R.drawable.quize,"Android Development","25 Questions"))
        list.add(QuizModel(R.drawable.quize,"Android Development","25 Questions"))
        list.add(QuizModel(R.drawable.quize,"Android Development","25 Questions"))
        list.add(QuizModel(R.drawable.quize,"Android Development","25 Questions"))
        list.add(QuizModel(R.drawable.quize,"Android Development","25 Questions"))
        list.add(QuizModel(R.drawable.quize,"Android Development","25 Questions"))
        list.add(QuizModel(R.drawable.quize,"Android Development","25 Questions"))

        binding.quizRecycler.adapter=QuizAdapter(this,list)
        binding.quizRecycler.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
    }
}