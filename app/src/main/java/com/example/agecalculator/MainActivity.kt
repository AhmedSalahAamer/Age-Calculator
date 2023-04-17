package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.agecalculator.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        button = findViewById(R.id.datePickerBTN)
        button.setOnClickListener {
            DatePicker()
        }


    }



    private fun DatePicker(){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this,
            {view, year, month, dayOfMonth ->


                val selectedDate ="$dayOfMonth/${month+1}/$year"
                binding.selectedDate.text = selectedDate


                binding.dateInminutes.text = setDate(selectedDate).toString()
            },
            year,
            month,
            day,
            )
        dpd.show()

    }

    private fun setDate(selectedDate:String): Long {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
        val theDate = sdf.parse(selectedDate)

        val selectedDateInminutes = theDate.time / 6000
        val currentDateInminutes = sdf.parse(sdf.format(System.currentTimeMillis())).time / 6000

        val AgeInMinutes = currentDateInminutes - selectedDateInminutes
        return AgeInMinutes
    }

}