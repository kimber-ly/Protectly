package com.example.protectly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StatusLaporanActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status_laporan)

        init()

        recyclerView.LayoutManager = LinearLayoutManager(this@StatusLaporanActivity)
        recyclerView.adapter = adapter
    }

    private fun init(){
        recyclerView = findViewById(R.id.recycler_view)

        val data = ArrayList<StatusLaporan>()
        data.add(StatusLaporan(R.drawable.baseline_arrow_forward, "Penyidikan", "Penipuan""Dilaporkan 22 September 2022", "Kode: XXXX/XXXXX/XXXXX"))
        data.add(StatusLaporan(R.drawable.baseline_arrow_forward, "Penyelidikan", "Pembegalan""Dilaporkan 12 Agustus 2022", "Kode: XXXX/XXXXX/XXXXX"))
        data.add(StatusLaporan(R.drawable.baseline_arrow_forward, "Penyelidikan Selesai", "Pembegalan""Dilaporkan 8 Mei 2022", "Kode: XXXX/XXXXX/XXXXX"))
        data.add(StatusLaporan(R.drawable.baseline_arrow_forward, "Penyidikan Diberhentikan", "Pembegalan""Dilaporkan 8 Mei 2022", "Kode: XXXX/XXXXX/XXXXX"))

        adapter = MyAdapter(data)
    }
}