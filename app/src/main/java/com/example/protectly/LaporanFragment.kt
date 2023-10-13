package com.example.protectly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class LaporanFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_laporan, container, false)

        recyclerView = view.findViewById(R.id.recycler_view_2)
        recyclerView.layoutManager = LinearLayoutManager(context)

        init()
        recyclerView.adapter = adapter
        return view
    }

    private fun init(){
        val data = ArrayList<StatusLaporan>()
        data.add(StatusLaporan(R.drawable.baseline_arrow_forward, "Penyidikan", "Penipuan","Dilaporkan 22 September 2022", "Kode: XXXX/XXXXX/XXXXX"))
        data.add(StatusLaporan(R.drawable.baseline_arrow_forward, "Penyelidikan", "Pembegalan","Dilaporkan 12 Agustus 2022", "Kode: XXXX/XXXXX/XXXXX"))
        data.add(StatusLaporan(R.drawable.baseline_arrow_forward, "Penyelidikan Selesai", "Pembegalan","Dilaporkan 8 Mei 2022", "Kode: XXXX/XXXXX/XXXXX"))
        data.add(StatusLaporan(R.drawable.baseline_arrow_forward, "Penyidikan Diberhentikan", "Pembegalan","Dilaporkan 8 Mei 2022", "Kode: XXXX/XXXXX/XXXXX"))

        adapter = MyAdapter(data)
    }
}