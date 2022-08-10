package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate: TextView? = null
    private var tvAgeInMinutes: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvAgeInMinutes = findViewById(R.id.tvAgeInMinutes)

        btnDatePicker.setOnClickListener {
            clickDatePick()
        }
    }

    private fun clickDatePick(){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this, {view, selectedYear, selectedMonth, selectedDayOfMonth ->
            val selectedDate = "${selectedYear}/${selectedMonth+1}/${selectedMonth}"
            tvSelectedDate?.text = selectedDate

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.KOREA)
            val theDate = sdf.parse(selectedDate)

            theDate.let {
                // 널세이프티를 위해서 let을 활용함
                val selectDateInMinutes = theDate.time / 60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                currentDate.let {
                    val currentDateInMinutes = currentDate.time / 60000
                    val differenceInMinutes = currentDateInMinutes - selectDateInMinutes
                    tvAgeInMinutes?.text = differenceInMinutes.toString()
                }

            }

        },
            year,
            month,
            day
        )
        // 현재 날짜보다 앞 날짜는 안나오도록 설정
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()
    }
}