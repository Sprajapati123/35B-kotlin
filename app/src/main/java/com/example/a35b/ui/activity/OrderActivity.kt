package com.example.a35b.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import com.example.a35b.R
import com.example.a35b.adapter.TabAdapter
import com.example.a35b.databinding.ActivityOrderBinding
import com.google.android.material.tabs.TabLayoutMediator

class OrderActivity : AppCompatActivity() {

    override fun onPause() {
        Log.d("lifecycle", "On pause -> I am called")
        super.onPause()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {

        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
    }

    lateinit var binding: ActivityOrderBinding
    lateinit var adapter: TabAdapter

    //if tab ma icon rakne bhaye
    val icons = arrayOf(
        R.drawable.baseline_search_24,
        R.drawable.baseline_notifications_24,
        R.drawable.baseline_home_24
    )
    //if tab ma text rakhne bhaye
    val data = arrayOf(
        "Active Order",
        "Delivered Order",
        "Cancelled Order"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager: FragmentManager = supportFragmentManager

        adapter = TabAdapter(fragmentManager, lifecycle)

        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) {
                    tab, position ->
//            tab.text = data[position]
            tab.icon = resources.getDrawable(icons[position],null)
        }.attach()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}