package com.example.collegeapp.fragments

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.activities.EditProfileActivity
import com.example.collegeapp.activities.OnboardingActivity
import com.example.collegeapp.activities.SingUpActivity
import com.example.collegeapp.databinding.FragmentSettingBinding
import com.example.collegeapp.models.ProfileModel
import com.example.collegeapp.models.UserModel
import com.google.firebase.auth.FirebaseAuth


class SettingFragment : Fragment() {
      private lateinit var binding: FragmentSettingBinding
      private lateinit var auth: FirebaseAuth
      private lateinit var dialog: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSettingBinding.inflate(layoutInflater)
        auth= FirebaseAuth.getInstance()
        dialog=ProgressDialog(requireContext())

        dialog.setTitle("Log Out")
        dialog.setMessage("please wait.... ")

       LogOut()

        val image=binding.userProfile.toString()
        binding.userProfile.setOnClickListener {
            startActivity(Intent(requireActivity(),EditProfileActivity::class.java))
            requireActivity().intent.putExtra("image",R.drawable.tushar)
        }

        return binding.root
    }

    private fun LogOut() {
        binding.logOut.setOnClickListener {

            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Warning!..")
            builder.setMessage("Are you shore want to logOut")

            builder.setPositiveButton(android.R.string.yes) { it, which ->
                dialog.show()
                    auth.signOut()
                    startActivity(Intent(requireContext(),SingUpActivity::class.java))

                val thread: Thread = object : Thread() {
                    override fun run() {
                        try {
                            sleep(7000)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        } finally {
                            dialog.dismiss()
                        }
                    }
                }
                thread.start()



            }

            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                builder.setCancelable(true)
            }
            builder.show()


        }
    }

}