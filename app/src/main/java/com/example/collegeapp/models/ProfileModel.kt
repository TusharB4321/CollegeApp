package com.example.collegeapp.models

import java.io.Serializable

data class ProfileModel(
     val uid:String?="",
     val name:String?="",
     val image:String?="",
     val field:String?="",
     val branch:String?="",
     val year:String?=""
 ):Serializable
