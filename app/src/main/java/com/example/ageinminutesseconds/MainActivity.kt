package com.example.ageinminutesseconds

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        well.setOnClickListener { view ->
            clickdate(view)
        }
    }

        fun clickdate(view: View) {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
           val dpd= DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, selectyear, selectmonth, selectdayOfMonth ->
                    val dateselected: String = "$selectdayOfMonth/${selectmonth + 1}/$selectyear"
                    textView2.setText(dateselected)
                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                    val thedate = sdf.parse(dateselected)
                    val dobinmins = thedate!!.time / 60000
                    val currentdate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    val curdateinmins = currentdate!!.time / 60000
                    val diffinmins = curdateinmins-dobinmins
                    textView3.setText(diffinmins.toString())
                    val diffindays= diffinmins/1440
                    textView4.setText(diffindays.toString())
                }
                , year
                , month
                , day)

        dpd.datePicker.setMaxDate(Date().time-86400000)
dpd.show()}

}