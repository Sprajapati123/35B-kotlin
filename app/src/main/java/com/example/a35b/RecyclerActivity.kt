package com.example.a35b

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a35b.adapter.FruitsAdapter

class RecyclerActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var imageList = ArrayList<Int>()
    var fruitsTitle = ArrayList<String>()
    var fruitsDesc = ArrayList<String>()

    lateinit var adapter: FruitsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler)
        recyclerView = findViewById(R.id.recyclerView)

        imageList.add(R.drawable.grapes)
        imageList.add(R.drawable.mango)
        imageList.add(R.drawable.apple)

        fruitsTitle.add("Grapes")
        fruitsTitle.add("Mango")
        fruitsTitle.add("Apple")

        fruitsDesc.add("this is grapes")
        fruitsDesc.add("this is mango")
        fruitsDesc.add("this is apple")



        adapter = FruitsAdapter(
            this@RecyclerActivity,
            imageList, fruitsTitle,fruitsDesc
        )

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this@RecyclerActivity,2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}