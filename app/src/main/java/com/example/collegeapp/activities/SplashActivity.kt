package com.example.collegeapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.collegeapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val thread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(3000)
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                   startActivity(Intent(this@SplashActivity,OnboardingActivity::class.java))
                    finish()
                }
            }
        }
             thread.start()
    }
}