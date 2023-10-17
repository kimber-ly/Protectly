package com.example.protectly.Laporan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LaporanAdapter(private val data: ArrayList<StatusLaporan>): RecyclerView.Adapter<LaporanViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaporanViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LaporanViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: LaporanViewHolder, position: Int) {
        holder.bind(data[position])
    }
}