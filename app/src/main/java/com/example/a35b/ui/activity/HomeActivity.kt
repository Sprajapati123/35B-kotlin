package com.example.a35b.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.a35b.R
import com.example.a35b.databinding.ActivityHomeBinding
import com.example.a35b.ui.fragment.FirstFragment
import com.example.a35b.ui.fragment.SecondFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFirst.setOnClickListener {
            val fragmentManager : FragmentManager =
                supportFragmentManager

            val fragmentTransaction : FragmentTransaction =
                fragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.frame,FirstFragment())

            fragmentTransaction.commit()

        }

        binding.btnSecond.setOnClickListener {
            val fragmentManager : FragmentManager =
                supportFragmentManager

            val fragmentTransaction : FragmentTransaction =
                fragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.frame,SecondFragment())
            fragmentTransaction.commit()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}