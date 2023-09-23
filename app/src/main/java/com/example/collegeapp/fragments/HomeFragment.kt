package com.example.collegeapp.fragments

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.collegeapp.R
import com.example.collegeapp.activities.SearchActivity
import com.example.collegeapp.adapters.CourseAdapter
import com.example.collegeapp.adapters.LangAdapter
import com.example.collegeapp.databinding.FragmentHomeBinding
import com.example.collegeapp.models.CourseModel
import com.example.collegeapp.models.LangModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore


class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding
    private lateinit var list:ArrayList<LangModel>
    private lateinit var list1:ArrayList<CourseModel>
    var dialog: ProgressDialog? = null
    var dbroot: FirebaseFirestore? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(layoutInflater)
        dialog = ProgressDialog(requireContext())
        dialog!!.setMessage("Uploading a data")
        dialog!!.show()
        dbroot = FirebaseFirestore.getInstance()


//        val image=intent.extras!!.getString("userImage")
//        Glide.with(requireContext()).load(image).into(binding.userImage)
        //val name=intent.getStringExtra("userName")
        //binding.userName.text=name
      slideImage()
      LangList()
      CourseList()



        return binding.root
    }

    private fun CourseList() {
        list1= ArrayList()

        binding.courseRecycler.adapter=CourseAdapter(requireContext(),list1)
        binding.courseRecycler.layoutManager=LinearLayoutManager(requireContext())
        binding.courseRecycler.setHasFixedSize(true)

        EventListener()
    }

    private fun EventListener() {
        dbroot!!.collection("Courses Info")
            .addSnapshotListener { value, error ->

                if (dialog!!.isShowing) dialog!!.dismiss()

                if (error != null) {
                    Log.e("Firestore Error", error.message!!)
                    return@addSnapshotListener
                }
                for (dc in value!!.documentChanges) {
                    if (dc.type == DocumentChange.Type.ADDED) {
                        list1.add(dc.document.toObject(CourseModel::class.java))
                    }
                    binding.courseRecycler.adapter!!.notifyDataSetChanged()
                }
            }
    }

    private fun LangList() {
        list= ArrayList()

        binding.langRecycler.adapter=LangAdapter(requireContext(),list)
        binding.langRecycler.layoutManager=StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)
        binding.langRecycler.setHasFixedSize(true)
        LangListener()
    }

    private fun LangListener() {
        dbroot!!.collection("Lang Info").addSnapshotListener{value,error->
            if (error!=null){
                return@addSnapshotListener
            }

            for (dc in value!!.documentChanges){
                if (dc.type==DocumentChange.Type.ADDED){
                    list.add(dc.document.toObject(LangModel::class.java))
                }
            }
            binding.langRecycler.adapter!!.notifyDataSetChanged()
        }
    }

    private fun slideImage(){
       val imageList=ArrayList<SlideModel>()
       imageList.add(SlideModel(R.drawable.reentc))
       imageList.add(SlideModel(R.drawable.cse))
       imageList.add(SlideModel(R.drawable.info))
       imageList.add(SlideModel(R.drawable.recmech))

       binding.imageSlider.setImageList(imageList)
       binding.imageSlider.setImageList(imageList,ScaleTypes.CENTER_INSIDE)

       val animation=AnimationUtils.loadAnimation(requireContext(),R.anim.slide_in_up)
       binding.search.setOnClickListener{
           binding.search.startAnimation(animation)
           startActivity(Intent(requireContext(),SearchActivity::class.java))
           activity?.overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up)
       }
   }

}