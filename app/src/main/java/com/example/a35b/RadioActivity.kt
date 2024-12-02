package com.example.a35b

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RadioActivity : AppCompatActivity() {

    lateinit var mango : RadioButton
    lateinit var apple : RadioButton
    lateinit var grapes : RadioButton
    lateinit var image : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio)
        mango = findViewById(R.id.btnMango)
        apple = findViewById(R.id.btnApple)
        grapes = findViewById(R.id.btnGrapes)
        image = findViewById(R.id.imageViewRadio)

        mango.setOnClickListener {
            image.setImageResource(R.drawable.mango)
        }
        apple.setOnClickListener {
            image.setImageResource(R.drawable.apple)
        }
        grapes.setOnClickListener {
            image.setImageResource(R.drawable.grapes)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}