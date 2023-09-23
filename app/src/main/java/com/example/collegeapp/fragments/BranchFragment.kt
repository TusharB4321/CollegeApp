package com.example.collegeapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.collegeapp.R
import com.example.collegeapp.activities.QuizeActivity
import com.example.collegeapp.adapters.BranchAdapter
import com.example.collegeapp.adapters.InterviewAdapter
import com.example.collegeapp.adapters.QuizAdapter
import com.example.collegeapp.databinding.FragmentBranchBinding
import com.example.collegeapp.models.BranchModel
import com.example.collegeapp.models.InterviewModel
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore


class BranchFragment : Fragment() {

    private lateinit var binding:FragmentBranchBinding
    private lateinit var list1:ArrayList<BranchModel>
    private lateinit var list2:ArrayList<InterviewModel>
    private lateinit var dbroot:FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentBranchBinding.inflate(layoutInflater)

        dbroot= FirebaseFirestore.getInstance()
        BranchList()
        InterviewList()



        binding.quiz.setOnClickListener{
            startActivity(Intent(requireContext(),QuizeActivity::class.java))

        }
        return binding.root
    }


    private fun BranchList() {

        list1= ArrayList()
        binding.branchRecycler.adapter=BranchAdapter(requireContext(),list1)
        binding.branchRecycler.layoutManager=StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        binding.branchRecycler.setHasFixedSize(true)

        dbroot!!.collection("Branch Info").addSnapshotListener{
                value,error->

            if (error!=null){
                return@addSnapshotListener
            }

            for (dc in value!!.documentChanges){
                if (dc.type==DocumentChange.Type.ADDED){
                    list1.add(dc.document.toObject(BranchModel::class.java))
                }
            }
            binding.branchRecycler.adapter!!.notifyDataSetChanged()
        }

    }

    private fun InterviewList() {

        list2= ArrayList()


        binding.interviewRecycler.adapter=InterviewAdapter(requireContext(),list2)
        binding.interviewRecycler.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.interviewRecycler.setHasFixedSize(true)

        dbroot!!.collection("Interview Info").addSnapshotListener{
                value,error->
            if (error!=null){
                return@addSnapshotListener
            }

            for (dc in value!!.documentChanges){
                if (dc.type==DocumentChange.Type.ADDED){
                    list2.add(dc.document.toObject(InterviewModel::class.java))
                }
            }
            binding.interviewRecycler.adapter!!.notifyDataSetChanged()
        }

    }


}