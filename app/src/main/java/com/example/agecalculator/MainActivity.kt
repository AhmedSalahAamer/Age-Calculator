package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.agecalculator.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.time.Year
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

        DatePickerDialog(this,
            {view, year, month, dayOfMonth ->
                val selectedDate ="$dayOfMonth/${month+1}/$year"
                binding.selectedDate.text = selectedDate
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                binding.dateInminutes.text = setDateInminutes(selectedDate,sdf).toString()
                binding.dateInHours.text = setDateInHours(selectedDate,sdf).toString()
                binding.dateInDays.text = setDateInDays(selectedDate,sdf).toString()
                binding.dateInYear.text = setDateInYear(selectedDate,sdf,year).toString()
            },
            year,
            month,
            day,
            ).show()


    }

    private fun setDateInminutes(selectedDate:String,sdf:SimpleDateFormat): Long {
        val theDate = sdf.parse(selectedDate)
        val selectedDateInminutes = theDate.time / 6000
        val currentDateInminutes = sdf.parse(sdf.format(System.currentTimeMillis())).time / 6000
        val AgeInMinutes = currentDateInminutes - selectedDateInminutes
        return AgeInMinutes
    }

    private fun setDateInHours(selectedDate:String,sdf:SimpleDateFormat): Long {
        val theDate = sdf.parse(selectedDate)
        val selectedDateInminutes = theDate.time / (6000*60)
        val currentDateInminutes = sdf.parse(sdf.format(System.currentTimeMillis())).time / (6000*60)
        val AgeInHours = currentDateInminutes - selectedDateInminutes
        return AgeInHours/10
    }
    private fun setDateInDays(selectedDate:String,sdf:SimpleDateFormat): Long {
        val theDate = sdf.parse(selectedDate)
        val selectedDateInminutes = theDate.time / (6000*60*24)
        val currentDateInminutes = sdf.parse(sdf.format(System.currentTimeMillis())).time / (6000*60*24)
        val AgeInDays = currentDateInminutes - selectedDateInminutes
        return AgeInDays/10
    }

    private fun setDateInYear(selectedDate:String,sdf:SimpleDateFormat,year:Int): Int {
        val theDate = sdf.parse(selectedDate)
        val selectedDateInminutes = year

        val currentDateInminutes = Calendar.getInstance().get(Calendar.YEAR)
        val AgeInYear = currentDateInminutes - selectedDateInminutes
        return AgeInYear
    }

}