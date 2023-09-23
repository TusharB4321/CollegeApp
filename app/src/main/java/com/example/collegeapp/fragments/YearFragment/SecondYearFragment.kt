package com.example.collegeapp.fragments.YearFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.collegeapp.R
import com.example.collegeapp.adapters.FirstYearAdapter
import com.example.collegeapp.adapters.SecondYearAdapter
import com.example.collegeapp.databinding.FragmentFirstYearBinding
import com.example.collegeapp.databinding.FragmentSecondYearBinding
import com.example.collegeapp.models.FirstYearModel
import com.example.collegeapp.models.SecondYearModel


class SecondYearFragment : Fragment() {

    private lateinit var binding:FragmentSecondYearBinding
    private lateinit var list:ArrayList<SecondYearModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSecondYearBinding.inflate(layoutInflater)


        list= ArrayList()

        list.add(SecondYearModel(R.drawable.imgg,R.drawable.book,"Mathematics-1","10 minute"))
        list.add(SecondYearModel(R.drawable.imgg,R.drawable.book,"Mathematics-1","10 minute"))
        list.add(SecondYearModel(R.drawable.imgg,R.drawable.book,"Mathematics-1","10 minute"))
        list.add(SecondYearModel(R.drawable.imgg,R.drawable.book,"Mathematics-1","10 minute"))
        list.add(SecondYearModel(R.drawable.imgg,R.drawable.book,"Mathematics-1","10 minute"))
        list.add(SecondYearModel(R.drawable.imgg,R.drawable.book,"Mathematics-1","10 minute"))
        list.add(SecondYearModel(R.drawable.imgg,R.drawable.book,"Mathematics-1","10 minute"))

        binding.secondRecycler.adapter= SecondYearAdapter(requireContext(),list)
        binding.secondRecycler.layoutManager= LinearLayoutManager(requireContext())

        return binding.root
    }

}