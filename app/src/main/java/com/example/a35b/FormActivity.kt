package com.example.a35b

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class FormActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner: Spinner
    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var display: TextView
    lateinit var datePicker: EditText
    val countries = arrayOf(
        "Nepal", "China",
        "India", "US", "Canada", "Australia"
    )

    val cities = arrayOf(
        "kathmandu", "Lalitpur",
        "Bhaktapur", "Kanchanpur", "Bhadrapur"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form)
        spinner = findViewById(R.id.spinner)
        display = findViewById(R.id.displaySpinner)
        autoCompleteTextView = findViewById(R.id.autoComplete)
        datePicker = findViewById(R.id.editTextDate)

        datePicker.isFocusable = false
        datePicker.isClickable = true
        datePicker.setOnClickListener {
            loadCalendar()
        }

        val autoCompleteAdapter = ArrayAdapter(
            this@FormActivity,
            android.R.layout.simple_dropdown_item_1line,
            cities
        )
        autoCompleteTextView.setAdapter(autoCompleteAdapter)
        autoCompleteTextView.threshold = 1

        val adapter = ArrayAdapter(
            this@FormActivity,
            android.R.layout.simple_spinner_item,
            countries
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinner.onItemSelectedListener = this
        spinner.adapter = adapter
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadCalendar() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(
            this@FormActivity,
            DatePickerDialog.OnDateSetListener
            { d, year, month, day ->
                         //2024   05    01
                datePicker.setText("$day/${month+1}/$year")
            },year,month,day
        )
        dialog.show()
    }

    override fun onItemSelected(p0: AdapterView<*>?, view: View?, p2: Int, p3: Long) {
        if (p0 != null) {
            display.text = p0.getItemAtPosition(p2).toString()
        }
    }


    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}