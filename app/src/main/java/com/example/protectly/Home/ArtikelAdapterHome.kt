package com.example.protectly.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.protectly.R

class ArtikelAdapterHome(private val artikel: ArrayList<ArtikelDataClassHome>)
    : RecyclerView.Adapter<ArtikelAdapterHome.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val gambar: ImageView = itemView.findViewById(R.id.img_artikel)
        val gambarPenulis: ImageView = itemView.findViewById(R.id.img_penulis)
        val namaPenulis: TextView = itemView.findViewById(R.id.nama_penulis)
        val tanggal: TextView = itemView.findViewById(R.id.tanggal_artikel)
        val judul: TextView = itemView.findViewById(R.id.judul_artikel)
        val kutipan: TextView = itemView.findViewById(R.id.kutipan_artikel)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.list_artikel, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.gambar.setImageResource(artikel[position].gambar)
        holder.gambarPenulis.setImageResource(artikel[position].profilePenulis)
        holder.namaPenulis.text = artikel[position].namaPenulis
        holder.tanggal.text = artikel[position].tanggal
        holder.judul.text = artikel[position].judul
        holder.kutipan.text = artikel[position].kutipan
    }

    override fun getItemCount(): Int {
        return artikel.size
    }

}