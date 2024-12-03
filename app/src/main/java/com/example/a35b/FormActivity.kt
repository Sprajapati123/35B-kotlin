package com.example.a35b

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner: Spinner
    lateinit var display: TextView
    val countries = arrayOf(
        "Nepal", "China",
        "India", "US", "Canada", "Australia"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form)
        spinner = findViewById(R.id.spinner)
        display = findViewById(R.id.displaySpinner)

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

    override fun onItemSelected(p0: AdapterView<*>?, view: View?, p2: Int, p3: Long) {
        if (p0 != null) {
            display.text = p0.getItemAtPosition(p2).toString()
        }
    }


    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}