package com.example.collegeapp.fragments.YearFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.collegeapp.R
import com.example.collegeapp.adapters.FirstYearAdapter
import com.example.collegeapp.databinding.FragmentFirstYearBinding
import com.example.collegeapp.models.FirstYearModel


@Suppress("UNREACHABLE_CODE")
class FirstYearFragment : Fragment() {

    private lateinit var binding:FragmentFirstYearBinding
    private lateinit var list: ArrayList<FirstYearModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentFirstYearBinding.inflate(layoutInflater)


        list= ArrayList()

        list.add(FirstYearModel(R.drawable.imgg,R.drawable.book,"Mathematics-1","10 minute"))
        list.add(FirstYearModel(R.drawable.imgg,R.drawable.book,"Mathematics-1","10 minute"))
        list.add(FirstYearModel(R.drawable.imgg,R.drawable.book,"Mathematics-1","10 minute"))
        list.add(FirstYearModel(R.drawable.imgg,R.drawable.book,"Mathematics-1","10 minute"))
        list.add(FirstYearModel(R.drawable.imgg,R.drawable.book,"Mathematics-1","10 minute"))
        list.add(FirstYearModel(R.drawable.imgg,R.drawable.book,"Mathematics-1","10 minute"))
        list.add(FirstYearModel(R.drawable.imgg,R.drawable.book,"Mathematics-1","10 minute"))
        list.add(FirstYearModel(R.drawable.imgg,R.drawable.book,"Mathematics-1","10 minute"))

        binding.firstRecycler.adapter=FirstYearAdapter(requireContext(),list)
        binding.firstRecycler.layoutManager=LinearLayoutManager(requireContext())

        return binding.root
    }

}