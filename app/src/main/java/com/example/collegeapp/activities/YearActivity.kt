package com.example.collegeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.collegeapp.R
import com.example.collegeapp.adapters.ViewPagerAdapter
import com.example.collegeapp.databinding.ActivityYearBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class YearActivity : AppCompatActivity() {

    private lateinit var binding:ActivityYearBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityYearBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val image=intent.extras!!.getString("image")
        val name=intent.getStringExtra("name")

        binding.branch.text=name
        Glide.with(applicationContext).load(image).into(binding.image)

        val adapter=ViewPagerAdapter(supportFragmentManager,lifecycle)
        binding.viewPager.adapter=adapter

        TabLayoutMediator(binding.tabLayout,binding.viewPager){tab,position->

            when(position){
                0->{
                    tab.text="1st Year"
                }
                1->{
                    tab.text="2nd Year"
                }
                2->{
                    tab.text="3rd Year"
                }
                3->{
                    tab.text="4th Year"
                }
            }
        }.attach()
    }
}