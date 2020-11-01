package com.example.todokotlin.Ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todokotlin.Adapter.WorkListAdapter
import com.example.todokotlin.R
import com.example.todokotlin.Room.WorkViewModel
import com.example.todokotlin.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private var backpressed: Long = 0
    private var backtost: Toast? = null
    private val newWordActivityRequestCode = 1
    private lateinit var workViewModel: WorkViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Set Toolbar and Drawer Menu
        setSupportActionBar(binding.toolbar)
        toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout,
            toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //Set Home Initially
        if (savedInstanceState == null) {
            binding.navView.setCheckedItem(R.id.nav_home)
        }

        //Add New Task
        binding.addWorkFloatingButton2.setOnClickListener {
            val intent = Intent(this, AddUpdateActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }

        // Navigation item Clicking Event
        binding.navView.setNavigationItemSelectedListener(this)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView2)
        val adapter = WorkListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        workViewModel = ViewModelProviders.of(this).get(WorkViewModel::class.java)


        workViewModel.allWorks.observe(
            this,
            Observer { works ->

                works?.let {
                    adapter.setWorks(it)
                }
            }
        )
    }

    // Inflate the menu for search and delete icon
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu2, menu)
        return true
    }

    // Navigation item select
    override fun onNavigationItemSelected(menuitem: MenuItem): Boolean {

        //Start-new-activity
        when (menuitem.itemId) {
            R.id.nav_addwork -> {
                val intent = Intent(this, AddUpdateActivity::class.java)
                startActivityForResult(intent, newWordActivityRequestCode)
            }

            R.id.nav_share -> {

            }
            R.id.nav_setting -> {
                startActivity(Intent(this, SettingActivity::class.java))
            }
            R.id.nav_about -> {
                startActivity(Intent(this, AboutActivity::class.java))
            }


        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    //Back pressed
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        if (backpressed + 2000 > System.currentTimeMillis()) {
            backtost?.cancel()
            super.onBackPressed()
            return
        } else {
            backtost = Toast.makeText(
                applicationContext,
                "Please click BACK again to exit",
                Toast.LENGTH_SHORT
            )
            backtost?.show()
        }
        backpressed = System.currentTimeMillis()
    }

}