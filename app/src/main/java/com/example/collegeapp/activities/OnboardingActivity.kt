package com.example.collegeapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.collegeapp.MainActivity
import com.example.collegeapp.adapters.OnboardingViewPagerAdapter
import com.example.collegeapp.databinding.ActivityOnboardingBinding
import com.example.collegeapp.fragments.OnboardingSceens.FirstScreen
import com.example.collegeapp.fragments.OnboardingSceens.SecondScreen
import com.example.collegeapp.fragments.OnboardingSceens.ThirdScreen
import com.google.firebase.auth.FirebaseAuth

class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentList= arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )



        binding.viewPager.adapter= OnboardingViewPagerAdapter(fragmentList,supportFragmentManager,lifecycle)

        auth= FirebaseAuth.getInstance()
        if (auth.currentUser!=null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}