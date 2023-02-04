package com.example.hw_3_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw_3_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
        lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, FirstFragment()).commit()
        }
    }
