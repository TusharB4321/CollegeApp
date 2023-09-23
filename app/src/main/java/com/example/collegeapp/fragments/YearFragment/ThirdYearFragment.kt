package com.example.collegeapp.fragments.YearFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.collegeapp.R
import com.example.collegeapp.adapters.SecondYearAdapter
import com.example.collegeapp.adapters.ThirdYearAdapter
import com.example.collegeapp.databinding.FragmentSecondYearBinding
import com.example.collegeapp.databinding.FragmentThirdYearBinding
import com.example.collegeapp.models.SecondYearModel
import com.example.collegeapp.models.ThirdYearModel


class ThirdYearFragment : Fragment() {

    private lateinit var binding: FragmentThirdYearBinding
    private lateinit var list:ArrayList<ThirdYearModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdYearBinding.inflate(layoutInflater)


        list = ArrayList()

        list.add(ThirdYearModel(R.drawable.imgg, R.drawable.book, "Mathematics-1", "10 minute"))
        list.add(ThirdYearModel(R.drawable.imgg, R.drawable.book, "Mathematics-1", "10 minute"))
        list.add(ThirdYearModel(R.drawable.imgg, R.drawable.book, "Mathematics-1", "10 minute"))
        list.add(ThirdYearModel(R.drawable.imgg, R.drawable.book, "Mathematics-1", "10 minute"))
        list.add(ThirdYearModel(R.drawable.imgg, R.drawable.book, "Mathematics-1", "10 minute"))
        list.add(ThirdYearModel(R.drawable.imgg, R.drawable.book, "Mathematics-1", "10 minute"))
        list.add(ThirdYearModel(R.drawable.imgg, R.drawable.book, "Mathematics-1", "10 minute"))
        list.add(ThirdYearModel(R.drawable.imgg, R.drawable.book, "Mathematics-1", "10 minute"))


        binding.thirdRecycler.adapter = ThirdYearAdapter(requireContext(), list)
        binding.thirdRecycler.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

}