package com.example.protectly.Laporan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.protectly.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class LaporanFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LaporanAdapter
    private lateinit var buatLaporan: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_laporan, container, false)
        buatLaporan = view.findViewById(R.id.buat_laporan_btn)
        buatLaporan.setOnClickListener{
            val intent = Intent(requireContext(), LaporanKosong::class.java)
            startActivity(intent)
        }

        recyclerView = view.findViewById(R.id.recycler_view_laporan)
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

        adapter = LaporanAdapter(data)
    }
}