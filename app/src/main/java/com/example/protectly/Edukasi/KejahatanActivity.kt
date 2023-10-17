package com.example.protectly.Edukasi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.protectly.R

class KejahatanActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var recyclerViewKejahatanAdapter: RecyclerViewKejahatanAdapter? = null
    private var kejahatanList = mutableListOf<kejahatan>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kejahatan)

        kejahatanList = ArrayList()

        recyclerView = findViewById(R.id.kejahatan_list) as RecyclerView
        recyclerViewKejahatanAdapter = RecyclerViewKejahatanAdapter(this@KejahatanActivity, kejahatanList)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewKejahatanAdapter

        PrepareKejahatanListData()
    }

    private fun PrepareKejahatanListData() {
        var kejahatan = kejahatan("Apa itu Tindak Kejahatan?", R.drawable.gambar_edukasi1)
        kejahatanList.add(kejahatan)
        kejahatan = kejahatan("Langkah Pertama Menghadapi Tindak Kejahatan", R.drawable.gambar_edukasi2)
        kejahatanList.add(kejahatan)
        kejahatan = kejahatan("Tips Agar Terhindar Dari Begal", R.drawable.gambar_edukasi3)
        kejahatanList.add(kejahatan)
        kejahatan = kejahatan("Tips Menangani Situasi Berbahaya Tindak Kejahatan", R.drawable.gambar_edukasi4)
        kejahatanList.add(kejahatan)
        kejahatan = kejahatan("Pentingnya Menyadari Situasi Lingkungan", R.drawable.gambar_edukasi5)
        kejahatanList.add(kejahatan)
        kejahatan = kejahatan("Jenis-Jenis Penipuan", R.drawable.gambar_edukasi6)
        kejahatanList.add(kejahatan)
    }
}