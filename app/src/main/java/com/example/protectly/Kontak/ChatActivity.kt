package com.example.protectly.Kontak

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.protectly.R

class ChatActivity : AppCompatActivity() {
    private lateinit var profilKontak: ImageView
    private lateinit var profilKontak2: ImageView
    private lateinit var namaKontak: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        profilKontak = findViewById(R.id.profil_kontak)
        profilKontak2 = findViewById(R.id.profil_kontak_2)
        namaKontak = findViewById(R.id.nama_kontak)

        profilKontak.setImageResource(intent.getIntExtra("gambar", 0))
        profilKontak2.setImageResource(intent.getIntExtra("gambar", 0))
        namaKontak.text = intent.getStringExtra("nama")
    }
}