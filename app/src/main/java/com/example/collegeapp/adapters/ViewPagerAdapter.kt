package com.example.collegeapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.collegeapp.fragments.YearFragment.FirstYearFragment
import com.example.collegeapp.fragments.YearFragment.FourthYearFragment
import com.example.collegeapp.fragments.YearFragment.SecondYearFragment
import com.example.collegeapp.fragments.YearFragment.ThirdYearFragment

class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {

        return when(position){

            0->{
                 FirstYearFragment()
            }
            1->{
                SecondYearFragment()
            }
            2->{
                ThirdYearFragment()
            }
            3->{
                FourthYearFragment()
            }

            else->{
                Fragment()
            }
        }
    }
}