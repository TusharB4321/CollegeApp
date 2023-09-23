package com.example.collegeapp.fragments.OnboardingSceens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.collegeapp.R
import com.example.collegeapp.activities.SingUpActivity
import com.example.collegeapp.databinding.FragmentFirstScreenBinding
import com.example.collegeapp.databinding.FragmentSecondScreenBinding
import com.example.collegeapp.databinding.FragmentSecondYearBinding

class SecondScreen : Fragment() {

    private lateinit var binding: FragmentSecondScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSecondScreenBinding.inflate(layoutInflater)

        binding.skip.setOnClickListener {
            startActivity(Intent(requireContext(), SingUpActivity::class.java))
        }
        return binding.root
    }


}