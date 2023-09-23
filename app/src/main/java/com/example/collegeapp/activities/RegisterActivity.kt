package com.example.collegeapp.activities

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.collegeapp.MainActivity
import com.example.collegeapp.R
import com.example.collegeapp.databinding.ActivityRegisterBinding
import com.example.collegeapp.models.ProfileModel
import com.example.collegeapp.models.UserModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var storage: FirebaseStorage
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var imageUri: Uri
    private lateinit var progress: ProgressDialog
    var reference: StorageReference? = null
    var root: FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = FirebaseDatabase.getInstance()
        storage = FirebaseStorage.getInstance()
        auth = FirebaseAuth.getInstance()

        root = FirebaseFirestore.getInstance()
        reference = storage!!.reference

        binding.camera.setOnClickListener {
           chooseImage()
        }

        binding.countinue.setOnClickListener {

                val name = binding.name.text.toString()
                val branchName = binding.branch.text.toString()
                val fieldName = binding.field.text.toString()
                val year = binding.year.text.toString()
//                val uid = auth.uid.toString()

               // val user = ProfileModel(name, branchName,fieldName,year,image,uid)

                //val userUid=auth.currentUser!!.uid

                if ((name.isEmpty()) && (branchName.isEmpty())&& (fieldName.isEmpty())&& (year.isEmpty())) {
                    Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                } else {

                    UploadPicture()

//                    root!!.collection("Profile Data").add(userUid)
//                        .addOnCompleteListener {
//
//                            if (it.isSuccessful) {
//                                UploadPicture()
//                                Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT)
//                                    .show()
//                                startActivity(Intent(this, MainActivity::class.java))
//                                finish()
//                            } else {
//                                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT)
//                                    .show()
//                            }
//                        }
//                        .addOnFailureListener {
//                            Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
//                        }
//
               }
            }



        }


    private fun chooseImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ((requestCode == 1) && (resultCode == RESULT_OK) && (data != null) && (data.data != null)) {
            imageUri = data.data!!
            binding!!.profile.setImageURI(imageUri)
            Toast.makeText(this, "Image Added Successfully", Toast.LENGTH_SHORT).show()
        }
    }

    private fun uploadImage(){

        val dialog = ProgressDialog(this)
        dialog.show()

        storage.getReference("UserImage").child(auth.currentUser!!.uid)
            .putFile(imageUri).addOnSuccessListener {
                Toast.makeText(this, "Profile successfully save", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener{
                Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
            }
            .addOnProgressListener { snapshot->
                val progressPercent=(100.00*snapshot.bytesTransferred/snapshot.totalByteCount)

                dialog.setMessage("Percentage"+progressPercent.toInt()+"%")

            }
    }

    private fun UploadPicture() {
        val dialog = ProgressDialog(this)
        dialog.setTitle("Profile Uploading....")
        val name=binding.name.text.toString()
        val image=binding.profile.setImageURI(imageUri).toString()
        dialog.show()
        val randomKey = UUID.randomUUID().toString()
        reference = reference!!.child("Profile Image").child("image$randomKey")
        reference!!.putFile((imageUri)!!)
            .addOnSuccessListener { taskSnapshot ->
                dialog.dismiss()
                val uri = taskSnapshot.uploadSessionUri
                Log.d("Url", (uri!!.path)!!)
                Snackbar.make(findViewById(android.R.id.content), "Post Uploaded", Snackbar.LENGTH_LONG)
                    .show()
                reference!!.downloadUrl.addOnCompleteListener { task ->
                    Log.d("url333", task.result.toString())
                    PostText(task.result.toString())
                    startActivity(Intent(this,MainActivity::class.java))
                    intent.putExtra("Username",name)
                    intent.putExtra("Userimage",image)
                    finish()
                }
            }.addOnFailureListener { e ->
                Toast.makeText(
                    this@RegisterActivity,
                    "Error" + e.message,
                    Toast.LENGTH_SHORT
                ).show()
            }.addOnProgressListener { snapshot ->
                val progressPercent = (100.00 * snapshot.bytesTransferred / snapshot.totalByteCount)
                dialog.setMessage("Percentage " + progressPercent.toInt() + "%")
            }
    }

    private fun PostText(url: String) {
        val items: MutableMap<String, String> = HashMap()
        items["image"] = url
        items["name"] = binding.name.text.toString().trim { it <= ' ' }
        items["branch"] = binding.branch.text.toString().trim { it <= ' ' }
        items["field"] = binding.field.text.toString().trim { it <= ' ' }
        items["year"] = binding.year.text.toString().trim { it <= ' ' }
        items["uid"] =auth.uid.toString()

        root!!.collection("Profile Info").add(items)
            .addOnCompleteListener {
                binding.name.setText("")
                binding.branch.setText("")
                binding.field.setText("")
                binding.year.setText("")
                finish()
            }
    }


   }
