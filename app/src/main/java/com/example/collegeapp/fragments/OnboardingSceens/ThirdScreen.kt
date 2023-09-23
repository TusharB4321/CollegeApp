package com.example.collegeapp.fragments.OnboardingSceens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.collegeapp.R
import com.example.collegeapp.activities.SingUpActivity
import com.example.collegeapp.databinding.FragmentSecondScreenBinding
import com.example.collegeapp.databinding.FragmentThirdScreenBinding


class ThirdScreen : Fragment() {

    private lateinit var binding: FragmentThirdScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentThirdScreenBinding.inflate(layoutInflater)


        val animation=AnimationUtils.loadAnimation(requireContext(),R.anim.bounce)
        val animation1=AnimationUtils.loadAnimation(requireContext(),R.anim.slide_in_left)
        binding.start.setOnClickListener {
            binding.start.startAnimation(animation)
            startActivity(Intent(requireContext(), SingUpActivity::class.java))
            binding.start.startAnimation(animation1)
            activity?.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_right)
            activity?.finish()
        }




        return binding.root
    }

    
}