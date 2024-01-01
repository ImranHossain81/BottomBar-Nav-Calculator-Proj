package com.example.bottombar_nav_calculatorproj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bottombar_nav_calculatorproj.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var actionBarDrawerTaggle: ActionBarDrawerToggle
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        var navConlloer = findNavController(R.id.fragmentContainerView)
        binding.bottonBar.setupWithNavController(navConlloer)

        actionBarDrawerTaggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.nav_open, R.string.nav_close);
        actionBarDrawerTaggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.draweNav.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment -> {
                    binding.drawerLayout.closeDrawers()
                    binding.draweNav.setupWithNavController(navConlloer)
                }
                R.id.profileFragment ->{
                    binding.drawerLayout.closeDrawers()
                    binding.draweNav.setupWithNavController(navConlloer)
                }
                R.id.settingsFragment ->{
                    binding.drawerLayout.closeDrawers()
                    binding.draweNav.setupWithNavController(navConlloer)
                }
                R.id.logout ->{
                    binding.drawerLayout.closeDrawers()
                    binding.draweNav.setupWithNavController(navConlloer)
                }
            }
            true
        }

    }
    // Imran Hossain............

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(actionBarDrawerTaggle.onOptionsItemSelected(item)){
            true
        }
        else super.onOptionsItemSelected(item)
    }
}