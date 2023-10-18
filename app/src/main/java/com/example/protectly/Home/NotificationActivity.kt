package com.example.protectly.Home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.protectly.Home.Settings.NotificationAdapter
import com.example.protectly.Home.Settings.NotificationData
import com.example.protectly.Home.Settings.SettingsActivity
import com.example.protectly.R

class NotificationActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var recyclerView: RecyclerView
    private var mList = ArrayList<NotificationData>()
    private lateinit var btnsetting: ImageButton
    private lateinit var adapter: NotificationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        btnsetting = findViewById(R.id.buttonSettings)
        btnsetting.setOnClickListener(this)

        recyclerView = findViewById(R.id.recyclerViewNotifikasi)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = NotificationAdapter(mList)
        addDataToList()
        recyclerView.adapter = adapter
    }



    private fun addDataToList() {
        mList.add(NotificationData("Daerah Rawan","Anda Sedang berada di daerah Rawan, hati-hati.",R.drawable.baseline_location_off_24))
        mList.add(NotificationData("Laporan","Laporan Pencurian Anda Sedang di Proses.",R.drawable.baseline_report_24))
        mList.add(NotificationData("Laporan","Laporan Pembegalan Anda Sedang di Selidiki.",R.drawable.baseline_report_24))
        mList.add(NotificationData("Ayah","Kamu Sudah dimana?",R.drawable.baseline_person_24))
        mList.add(NotificationData("Ibu","Hati-hati di jalan?",R.drawable.baseline_person_24))
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.buttonSettings -> {
                val intent = Intent(this@NotificationActivity, SettingsActivity::class.java)
                startActivity(intent)
            }
        }
}}
