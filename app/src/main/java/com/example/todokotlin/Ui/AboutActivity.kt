package com.example.todokotlin.Ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todokotlin.R
import com.example.todokotlin.databinding.ActivityAboutBinding
import com.example.todokotlin.databinding.ActivityAddUpdateBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        title = "Add Work"

    }
}