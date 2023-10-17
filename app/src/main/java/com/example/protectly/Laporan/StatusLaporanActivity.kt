package com.example.protectly.Laporan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.protectly.R

class StatusLaporanActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LaporanAdapter
//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status_laporan)

        init()

        recyclerView.layoutManager = LinearLayoutManager(this@StatusLaporanActivity)
        recyclerView.adapter = adapter
    }

    private fun init(){
        recyclerView = findViewById(R.id.recycler_view)

        val data = ArrayList<StatusLaporan>()
        data.add(StatusLaporan(R.drawable.baseline_arrow_forward, "Penyidikan", "Penipuan","Dilaporkan 22 September 2022", "Kode: XXXX/XXXXX/XXXXX"))
        data.add(StatusLaporan(R.drawable.baseline_arrow_forward, "Penyelidikan", "Pembegalan","Dilaporkan 12 Agustus 2022", "Kode: XXXX/XXXXX/XXXXX"))
        data.add(StatusLaporan(R.drawable.baseline_arrow_forward, "Penyelidikan Selesai", "Pembegalan","Dilaporkan 8 Mei 2022", "Kode: XXXX/XXXXX/XXXXX"))
        data.add(StatusLaporan(R.drawable.baseline_arrow_forward, "Penyidikan Diberhentikan", "Pembegalan","Dilaporkan 8 Mei 2022", "Kode: XXXX/XXXXX/XXXXX"))

        adapter = LaporanAdapter(data)
    }
}