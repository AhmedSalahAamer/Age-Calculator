package com.example.agecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.agecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()

    }

    private fun getData(){
        button = findViewById(R.id.datePickerBTN)
    }
}