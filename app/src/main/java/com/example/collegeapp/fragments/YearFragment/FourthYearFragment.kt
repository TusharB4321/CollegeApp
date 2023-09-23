package com.example.collegeapp.fragments.YearFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.collegeapp.R
import com.example.collegeapp.adapters.FourthYearAdapter
import com.example.collegeapp.adapters.ThirdYearAdapter
import com.example.collegeapp.databinding.FragmentFourthYearBinding
import com.example.collegeapp.databinding.FragmentThirdYearBinding
import com.example.collegeapp.models.FourthYearModel
import com.example.collegeapp.models.ThirdYearModel


class FourthYearFragment : Fragment() {

    private lateinit var binding: FragmentFourthYearBinding
    private lateinit var list:ArrayList<FourthYearModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFourthYearBinding.inflate(layoutInflater)


        list = ArrayList()

        list.add(FourthYearModel(R.drawable.imgg, R.drawable.book, "Mathematics-1", "10 minute"))
        list.add(FourthYearModel(R.drawable.imgg, R.drawable.book, "Mathematics-1", "10 minute"))
        list.add(FourthYearModel(R.drawable.imgg, R.drawable.book, "Mathematics-1", "10 minute"))
        list.add(FourthYearModel(R.drawable.imgg, R.drawable.book, "Mathematics-1", "10 minute"))
        list.add(FourthYearModel(R.drawable.imgg, R.drawable.book, "Mathematics-1", "10 minute"))
        list.add(FourthYearModel(R.drawable.imgg, R.drawable.book, "Mathematics-1", "10 minute"))
        list.add(FourthYearModel(R.drawable.imgg, R.drawable.book, "Mathematics-1", "10 minute"))
        list.add(FourthYearModel(R.drawable.imgg, R.drawable.book, "Mathematics-1", "10 minute"))


        binding.fourthRecycler.adapter = FourthYearAdapter(requireContext(), list)
        binding.fourthRecycler.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

}