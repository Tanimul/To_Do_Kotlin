package com.example.todokotlin.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todokotlin.R
import com.example.todokotlin.databinding.ActivityAddUpdateBinding
import com.example.todokotlin.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

       
    }
}