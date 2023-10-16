package com.example.protectly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class KontakFragment2 : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var mList = ArrayList<ListKontak>()
    private lateinit var adapter: ListAdapter
//
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_kontak_2, container, false)

        recyclerView = view.findViewById(R.id.listView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        addDataToList()
        adapter = ListAdapter(mList)
        recyclerView.adapter = adapter

        return view
    }

    private fun addDataToList() {
        mList.add(ListKontak("Polisi", "112", R.drawable.img_kontak2))
        mList.add(ListKontak("Ayah", "+62 8967821", R.drawable.img_kontak3))
        mList.add(ListKontak("Ibu", "+62 7801569", R.drawable.img_kontak4))
        mList.add(ListKontak("Bestie", "+62 7118450", R.drawable.img_kontak5))
        mList.add(ListKontak("Abang", "+62 2186610", R.drawable.img_kontak6))
        mList.add(ListKontak("Pak RT", "+62 896778", R.drawable.img_kontak_6))
    }

}