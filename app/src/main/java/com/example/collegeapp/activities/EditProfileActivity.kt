package com.example.collegeapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.collegeapp.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding:ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val bundle = intent.extras
        if (bundle != null) {
            val resId = bundle.getInt("image")
            binding.profile.setImageResource(resId)
        }


    }
}