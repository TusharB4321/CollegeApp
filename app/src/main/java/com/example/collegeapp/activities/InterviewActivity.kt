package com.example.collegeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.collegeapp.R
import com.example.collegeapp.adapters.InterviewQuestionAdapter
import com.example.collegeapp.databinding.ActivityInterviewBinding
import com.example.collegeapp.models.InterviewQuestionModel

class InterviewActivity : AppCompatActivity() {

    private lateinit var binding:ActivityInterviewBinding
    private lateinit var list:ArrayList<InterviewQuestionModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityInterviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val image=intent.extras!!.getString("image")
        Glide.with(applicationContext).load(image).into(binding.image)

        list= ArrayList()

        list.add(InterviewQuestionModel(R.drawable.discussion,"1","What is basic fundamental of the object orianted programming ?","Lorem ipsum dolor sit amet, labore et dolore magna aliqua."))
        list.add(InterviewQuestionModel(R.drawable.discussion,"2","What is basic fundamental of the object orianted programming ?","Lorem ipsum dolor sit amet, labore et dolore magna aliqua."))
        list.add(InterviewQuestionModel(R.drawable.discussion,"3","What is basic fundamental of the object orianted programming ?","Lorem ipsum dolor sit amet, labore et dolore magna aliqua."))
        list.add(InterviewQuestionModel(R.drawable.discussion,"4","What is basic fundamental of the object orianted programming ?","Lorem ipsum dolor sit amet, labore et dolore magna aliqua."))
        list.add(InterviewQuestionModel(R.drawable.discussion,"5","What is basic fundamental of the object orianted programming ?","Lorem ipsum dolor sit amet, labore et dolore magna aliqua."))
        list.add(InterviewQuestionModel(R.drawable.discussion,"6","What is basic fundamental of the object orianted programming ?","Lorem ipsum dolor sit amet, labore et dolore magna aliqua."))
        list.add(InterviewQuestionModel(R.drawable.discussion,"7","What is basic fundamental of the object orianted programming ?","Lorem ipsum dolor sit amet, labore et dolore magna aliqua."))
        list.add(InterviewQuestionModel(R.drawable.discussion,"8","What is basic fundamental of the object orianted programming ?","Lorem ipsum dolor sit amet, labore et dolore magna aliqua."))
        list.add(InterviewQuestionModel(R.drawable.discussion,"9","What is basic fundamental of the object orianted programming ?","Lorem ipsum dolor sit amet, labore et dolore magna aliqua."))

        binding.interviewQueRecycler.adapter=InterviewQuestionAdapter(this,list)
        binding.interviewQueRecycler.layoutManager=LinearLayoutManager(this)

    }
}