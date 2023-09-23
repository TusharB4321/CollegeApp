package com.example.collegeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.collegeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragment)
        val navController=navHostFragment!!.findNavController()

        val popupMenu= PopupMenu(this,null)
        popupMenu.inflate(R.menu.menu)
        binding.bottomBar.setupWithNavController(popupMenu.menu,navController)
    }
}