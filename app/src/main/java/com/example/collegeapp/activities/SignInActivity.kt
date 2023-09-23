package com.example.collegeapp.activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.collegeapp.MainActivity
import com.example.collegeapp.R
import com.example.collegeapp.databinding.ActivitySignInBinding
import com.example.collegeapp.models.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var auth:FirebaseAuth
    private lateinit var database:FirebaseDatabase
    private lateinit var progress: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUp.setOnClickListener {
            startActivity(Intent(this,SingUpActivity::class.java))
        }

        binding.google.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))

        }

        progress= ProgressDialog(this)
        progress.setTitle("Creating Account")
        progress.setMessage("we are creating your account ")


        binding.imageView2.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))

        }

        SignIn()
    }

    private fun SignIn() {

        auth=FirebaseAuth.getInstance()
        database=FirebaseDatabase.getInstance()

        binding.signin.setOnClickListener {

            progress.show()

            val email=binding.UserEmail.text.toString()
            val password=binding.UserPassword.text.toString()

            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {

                if (email.isNotEmpty()&&password.isNotEmpty()){
                    progress.dismiss()
                    if (it.isSuccessful){

                        startActivity(Intent(this,MainActivity::class.java))
                        finish()

                    }else{
                        Toast.makeText(this, "Wrong email or password", Toast.LENGTH_SHORT).show()
                    }

                }else{
                    Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}