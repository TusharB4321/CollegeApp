package com.example.collegeapp.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.collegeapp.R
import com.example.collegeapp.adapters.MessageAdapter
import com.example.collegeapp.databinding.ActivityMessageBinding
import com.example.collegeapp.models.MessageModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.net.URI
import java.util.*
import kotlin.collections.ArrayList

class MessageActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMessageBinding

    private lateinit var database: FirebaseDatabase
    private lateinit var imageUri: Uri
    private lateinit var senderUid: String
    private lateinit var receiverUid: String

    private lateinit var senderRoom: String
    private lateinit var receiverRoom: String


    private lateinit var list: ArrayList<MessageModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database=FirebaseDatabase.getInstance()

        list= ArrayList()

        senderUid= FirebaseAuth.getInstance().uid.toString()
        receiverUid= intent.getStringExtra("uid").toString()

        senderRoom= senderUid+receiverUid
        receiverRoom= receiverUid+senderUid


        val name=intent.getStringExtra("name")
        val branch=intent.getStringExtra("branch")
        val field=intent.getStringExtra("field")
        val year=intent.getStringExtra("year")
        val image=intent.extras!!.getString("image")

        binding.name.text=name
        binding.field.text=field
        Glide.with(applicationContext).load(image).into(binding.image)


        binding.image.setOnClickListener {
            startActivity(Intent(this@MessageActivity,EditProfileActivity::class.java))
            finish()
        }

        binding.send.setOnClickListener{

            if (binding.message.text.isEmpty()){
                Toast.makeText(this,"Please enter your message", Toast.LENGTH_SHORT).show()
            }
            else{

                val message=MessageModel(binding.message.text.toString(),senderUid, Date().time)

                val randomKey=database.reference.push().key

                database.reference.child("Chats").child(senderRoom).child("message")

                    .child(randomKey!!).setValue(message).addOnSuccessListener {

                        database.reference.child("Chats").child(receiverRoom).child("message")
                            .child(randomKey).setValue(message).addOnSuccessListener {

                                binding.message.text=null
                                Toast.makeText(this,"Message sent..", Toast.LENGTH_SHORT).toString()


                            }
                            .addOnFailureListener{
                                Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
                            }
                    }


            }
        }


        database.reference.child("Chats").child(senderRoom).child("message")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    list.clear()
                    for (snapshot1 in snapshot.children){

                        val data=snapshot1.getValue(MessageModel::class.java)
                        list.add(data!!)
                    }

                    binding.messageRecy.adapter= MessageAdapter(this@MessageActivity,list)
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@MessageActivity,"Error : $error",Toast.LENGTH_SHORT).show()
                }

            })
    }
}