package com.example.collegeapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.collegeapp.R
import com.example.collegeapp.adapters.ChatAdapter
import com.example.collegeapp.models.ChatModel
import com.example.collegeapp.databinding.FragmentChatBinding
import com.example.collegeapp.models.ProfileModel
import com.example.collegeapp.models.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore


class ChatFragment : Fragment() {
    private lateinit var binding: FragmentChatBinding
    private lateinit var list: ArrayList<ProfileModel>
    private lateinit var database: FirebaseDatabase
    private lateinit var dbroot:FirebaseFirestore
    private lateinit var auth:FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentChatBinding.inflate(layoutInflater)
        list= ArrayList()


        database= FirebaseDatabase.getInstance()
        dbroot= FirebaseFirestore.getInstance()
        auth= FirebaseAuth.getInstance()

        var userUid=auth.currentUser!!.uid



        dbroot.collection("Profile Info").addSnapshotListener{
            value,error->
            if (error!=null){
                return@addSnapshotListener
            }

            list.clear()

            for (dc in value!!.documentChanges){
                if (dc.type==DocumentChange.Type.ADDED){
                    val user=ProfileModel()
                    if (user.uid!=userUid){
                        list.add(dc.document.toObject(ProfileModel::class.java))
                    }

                }
                binding.recyclerview.adapter=ChatAdapter(requireContext(),list)
                binding.recyclerview.adapter!!.notifyDataSetChanged()
            }

        }
//        database.reference.child("Profile Info").addValueEventListener(object :ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                list.clear()
//                for (value in snapshot.children){
//                    val user=value.getValue(ProfileModel::class.java)
//
//                    if (user!!.uid!=auth.currentUser!!.uid){
//                       list.add(user)
//                    }
//                }
//                binding.recyclerview.adapter=ChatAdapter(requireContext(),list)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(requireContext(), error.message.toString(), Toast.LENGTH_SHORT).show()
//            }
//
//        })



        return binding.root



    }


}