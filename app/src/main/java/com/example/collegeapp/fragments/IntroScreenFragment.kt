package com.example.collegeapp.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.activities.OnboardingActivity
import com.example.collegeapp.databinding.FragmentIntroScreenBinding
import com.example.collegeapp.databinding.FragmentThirdScreenBinding


class IntroScreenFragment : Fragment() {

    private lateinit var binding: FragmentIntroScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentIntroScreenBinding.inflate(layoutInflater)

        Handler().postDelayed({
            startActivity(Intent(requireContext(),OnboardingActivity::class.java))
        },3000)

        return binding.root
    }


}