package com.example.todokotlin.Ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todokotlin.R

class AddUpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_update)
        title = "Add Work"
    }
}