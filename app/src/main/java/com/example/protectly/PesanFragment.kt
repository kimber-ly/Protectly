package com.example.protectly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PesanFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var listPesan = ArrayList<ListPesan>()
    private lateinit var adapter: PesanAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pesan_, container, false)
        recyclerView = view.findViewById(R.id.recycler_msg)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        addPesanToList()

        adapter = PesanAdapter(listPesan)
        recyclerView.adapter = adapter

        return view
    }

    private fun addPesanToList() {
        listPesan.add(ListPesan("Polisi", "Ada yang bisa saya bantu?", R.drawable.img_kontak2))
        listPesan.add(ListPesan("Ayah", "Ayah segera kesana", R.drawable.img_kontak3))
        listPesan.add(ListPesan("Ibu", "Ibu butuh pertolongan kamu", R.drawable.img_kontak4))
        listPesan.add(ListPesan("Bestie", "Kamu stay dulu ya disana...", R.drawable.img_kontak5))
        listPesan.add(ListPesan("Abang", "Ade tenang dulu...", R.drawable.img_kontak6))
        listPesan.add(ListPesan("Pak RT", "Apakah ada masalah?", R.drawable.img_kontak_6))
    }

}