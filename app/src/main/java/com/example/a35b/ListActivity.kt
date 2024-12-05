package com.example.a35b

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListActivity : AppCompatActivity() {
    lateinit var listView: ListView
    val contacts = arrayOf(
        "ram","shyam","hari","gita","sita","ram","shyam","hari","gita","sita",
        "ram","shyam","hari","gita","sita",
        "ram","shyam","hari","gita","sita",
        "ram","shyam","hari","gita","sita",
        "ram","shyam","hari","gita","sita",
        "ram","shyam","hari","gita","sita",
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        listView = findViewById(R.id.lstView)

        val adapter = ArrayAdapter(
            this@ListActivity,
            android.R.layout.simple_list_item_1,
            contacts
        )
        listView.adapter = adapter

        listView.setOnItemClickListener {
           adapterView, view, i, l ->
            if(adapterView != null){

            Toast.makeText(
                this@ListActivity,
                adapterView.getItemAtPosition(i).toString(),
                Toast.LENGTH_SHORT
                ).show()
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}