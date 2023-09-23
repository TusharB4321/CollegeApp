package com.example.collegeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentBranchBinding
import com.example.collegeapp.databinding.FragmentIntroductionBinding


class IntroductionFragment : Fragment() {
     private lateinit var binding:FragmentIntroductionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentIntroductionBinding.inflate(layoutInflater)



        return binding.root
    }


}