package com.example.a35b.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a35b.R
import de.hdodenhof.circleimageview.CircleImageView


class FruitsAdapter(
    val context: Context,
    val imageList : ArrayList<Int>,
    val fruitsTitle : ArrayList<String>,
    val imageDesc : ArrayList<String>,
) : RecyclerView.Adapter<FruitsAdapter.FruitsViewHolder>(){
    class FruitsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : CircleImageView = itemView.findViewById(R.id.profile_image)
        val title : TextView = itemView.findViewById(R.id.lblFruitName)
        val desc : TextView = itemView.findViewById(R.id.lblDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
        val itemView : View = LayoutInflater.from(context).inflate(R.layout.single_product,parent,false)
        return FruitsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return imageDesc.size
    }

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        holder.desc.text = imageDesc[position]
        holder.title.text = fruitsTitle[position]
        holder.imageView.setImageResource(imageList[position])
    }
}