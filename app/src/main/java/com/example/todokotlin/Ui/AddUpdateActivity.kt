package com.example.todokotlin.Ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todokotlin.databinding.ActivityAddUpdateBinding

class AddUpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        title = "Add Work"



    }
}