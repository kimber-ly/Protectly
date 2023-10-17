package com.example.protectly

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChatActivity : AppCompatActivity() {
    private lateinit var profilKontak: ImageView
    private lateinit var namaKontak: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        profilKontak = findViewById(R.id.profil_kontak)
        namaKontak = findViewById(R.id.nama_kontak)

        profilKontak.setImageResource(intent.getIntExtra("gambar", 0))
        namaKontak.text = intent.getStringExtra("nama")
    }
}