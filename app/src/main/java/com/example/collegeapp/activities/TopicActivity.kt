package com.example.collegeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.collegeapp.R
import com.example.collegeapp.adapters.TopicViewPagerAdapter
import com.example.collegeapp.databinding.ActivityTopicBinding
import com.google.android.material.tabs.TabLayoutMediator

class TopicActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTopicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTopicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter=TopicViewPagerAdapter(supportFragmentManager,lifecycle)
        binding.viewPager.adapter=adapter

        TabLayoutMediator(binding.tabLayout,binding.viewPager){
            tab,position->

            when(position){
                0->{
                  tab.text="Introduction"
                }
                1->{
                    tab.text="Code"
                }
            }
        }.attach()


    }
}