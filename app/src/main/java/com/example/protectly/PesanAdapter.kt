package com.example.protectly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PesanAdapter
    (private val listPesan: ArrayList<ListPesan>): RecyclerView.Adapter<PesanAdapter.ViewHolderPesan>() {
//
    inner class ViewHolderPesan(view: View): RecyclerView.ViewHolder(view){
        val nama: TextView = view.findViewById(R.id.contact_name)
        val msg: TextView = view.findViewById(R.id.contact_msg)
        val img: ImageView = view.findViewById(R.id.contact_img)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPesan {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_pesan, parent, false)
        return ViewHolderPesan(view)
    }

    override fun onBindViewHolder(holder: ViewHolderPesan, position: Int) {
        holder.nama.text = listPesan[position].name
        holder.msg.text = listPesan[position].message
        holder.img.setImageResource(listPesan[position].image)
    }

    override fun getItemCount(): Int {
        return listPesan.size
    }

}