package com.example.protectly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewKejahatanAdapter(private val activity: KejahatanActivity, private val kejahatanList: List<kejahatan>) :
    RecyclerView.Adapter<RecyclerViewKejahatanAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_kejahatan_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.kejahatanJudul.text = kejahatanList[position].title
        holder.kejahatanGambar.setImageResource(kejahatanList[position].image)
        holder.cardView.setOnClickListener {
            Toast.makeText(activity, kejahatanList[position].title, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return kejahatanList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val kejahatanJudul: TextView = itemView.findViewById(R.id.kejahatan_judul)
        val kejahatanGambar: ImageView = itemView.findViewById(R.id.gambar_kejahatan)
        val cardView: CardView = itemView.findViewById(R.id.CardView)
    }
}
