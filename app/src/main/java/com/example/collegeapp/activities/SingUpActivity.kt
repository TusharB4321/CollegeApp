package com.example.collegeapp.activities

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.collegeapp.MainActivity
import com.example.collegeapp.R
import com.example.collegeapp.databinding.ActivitySingUpBinding
import com.example.collegeapp.models.UserModel
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.FirebaseDatabase

class SingUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingUpBinding
    private lateinit var database:FirebaseDatabase
    private lateinit var auth:FirebaseAuth
    private lateinit var gso:GoogleSignInOptions
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var progress:ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySingUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.siggn.setOnClickListener {
            startActivity(Intent(this,SignInActivity::class.java))
        }

        progress= ProgressDialog(this)
        progress.setTitle("Creating Account")
        progress.setMessage("we are creating your account ")


        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(R.string.default_web_client_id.toString())
            .requestEmail()
            .build()

        googleSignInClient=GoogleSignIn.getClient(this,gso)

        binding.google.setOnClickListener {
            signInGoogle()
        }
        SignUp()


    }

    private fun signInGoogle() {
        val signInIntent=googleSignInClient.signInIntent
        launcher.launch(signInIntent)
    }

    private val launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result->

        if (result.resultCode==Activity.RESULT_OK){
            val task=GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleResults(task)
        }
    }

    private fun handleResults(task: Task<GoogleSignInAccount>) {

        if (task.isSuccessful){
            val account:GoogleSignInAccount?=task.result
            if (account!=null){
                UpdateUI(account)
            }
        }else{
            Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun UpdateUI(account: GoogleSignInAccount) {

        val credential=GoogleAuthProvider.getCredential(account.idToken,null)
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful){
                startActivity(Intent(this,RegisterActivity::class.java))
                finish()
            }
            else{
                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun SignUp() {
        auth= FirebaseAuth.getInstance()
        database=FirebaseDatabase.getInstance()

        binding.signUp.setOnClickListener {

            progress.show()

            val mobNum=binding.mobileNumber.text.toString()
            val email=binding.email.text.toString()
            val password=binding.password.text.toString()

            val userModel=UserModel(mobNum,email,password)

            if (mobNum.isNotEmpty()&&email.isNotEmpty()&&password.isNotEmpty()){

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {

                    if (it.isSuccessful){
                        progress.dismiss()

                        val id=it.getResult().user!!.uid
                        database.getReference().child("Users").child(id).setValue(userModel)
                            startActivity(Intent(this,RegisterActivity::class.java))
                            finish()


                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                progress.dismiss()
                Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()

        if (auth.currentUser!=null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}