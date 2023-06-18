package com.example.slideablemenuwithnavigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        drawerLayout = findViewById(R.id.drawerLayout)
        navView = findViewById(R.id.navigation
        )

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)    // jab ham usa close karaan to wo band ho jaya


        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem1 -> Toast.makeText(this,"Clicked item 1", Toast.LENGTH_SHORT).show()
                R.id.miItem2 -> Toast.makeText(this,"Clicked item 2", Toast.LENGTH_SHORT).show()
                R.id.miItem3 -> Toast.makeText(this,"Clicked item 3", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}