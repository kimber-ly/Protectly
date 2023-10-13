package com.example.protectly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private var mList: ArrayList<ListKontak>) :
    RecyclerView.Adapter<ListAdapter.LanguageViewHolder>() {

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image : ImageView = itemView.findViewById(R.id.listImage1)
        val nomor : TextView = itemView.findViewById(R.id.listnomor1)
        val nama : TextView = itemView.findViewById(R.id.listName1)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_kontak , parent , false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.image.setImageResource(mList[position].image)
        holder.nama.text = mList[position].name
        holder.nomor.text = mList[position].nomor

    }

    override fun getItemCount(): Int {
        return mList.size
    }
}