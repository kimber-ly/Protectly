package com.example.protectly.Laporan

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.protectly.R

class LaporanViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(
    R.layout.recycler_view_template, parent, false)) {

    private var imgView: ImageView? = null
    private var txtStatus: TextView? = null
    private var txtJenis: TextView? = null
    private var txtWaktu: TextView? = null
    private var txtKode: TextView? = null

    init {
        imgView = itemView.findViewById(R.id.img_view)
        txtStatus = itemView.findViewById(R.id.txt_status)
        txtJenis = itemView.findViewById(R.id.txt_jenis)
        txtWaktu = itemView.findViewById(R.id.txt_waktu)
        txtKode = itemView.findViewById(R.id.txt_kode)
    }

    fun bind(data: StatusLaporan){
        imgView?.setImageResource(data.imgView)
        txtStatus?.text = data.txtStatus
        txtJenis?.text = data.txtJenis
        txtWaktu?.text = data.txtWaktu
        txtKode?.text = data.txtKode
    }
}