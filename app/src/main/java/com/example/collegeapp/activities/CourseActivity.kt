package com.example.collegeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.collegeapp.R
import com.example.collegeapp.adapters.DevelopAdapter
import com.example.collegeapp.databinding.ActivityCourseBinding
import com.example.collegeapp.databinding.ActivityYearBinding
import com.example.collegeapp.models.DevelopModel

class CourseActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCourseBinding
    private lateinit var list: ArrayList<DevelopModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val name=intent.getStringExtra("name")
//        val des=intent.getStringExtra("des")
//        val image=intent.extras!!.getString("image")

//       binding.courseName.text=name
//        binding.courseDes.text=des
        //Glide.with(applicationContext).load(image).into(binding.courseImage)


        list= ArrayList()

        list.add(DevelopModel(R.drawable.recta,R.drawable.book,"Introduction","10 minute"))
        list.add(DevelopModel(R.drawable.recta,R.drawable.book,"Introduction","10 minute"))
        list.add(DevelopModel(R.drawable.recta,R.drawable.book,"Introduction","10 minute"))
        list.add(DevelopModel(R.drawable.recta,R.drawable.book,"Introduction","10 minute"))
        list.add(DevelopModel(R.drawable.recta,R.drawable.book,"Introduction","10 minute"))
        list.add(DevelopModel(R.drawable.recta,R.drawable.book,"Introduction","10 minute"))

        binding.courseRecycle.adapter=DevelopAdapter(this,list)
        binding.courseRecycle.layoutManager=LinearLayoutManager(this)


    }
}