package com.example.a35b.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a35b.R
import de.hdodenhof.circleimageview.CircleImageView

class FruitsAdapter(
    val context: Context,
    val imageList: ArrayList<Int>,
    val fruitsTitle: ArrayList<String>,
    val fruitsDesc: ArrayList<String>
) : RecyclerView.Adapter<FruitsAdapter.FruitsViewHolder>() {
    class FruitsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: CircleImageView = itemView.findViewById(R.id.profile_image)
        var title: TextView = itemView.findViewById(R.id.lblFruitName)
        var desc: TextView = itemView.findViewById(R.id.lblDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {

    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {

    }
}