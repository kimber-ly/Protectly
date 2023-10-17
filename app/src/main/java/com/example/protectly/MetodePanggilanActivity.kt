package com.example.protectly

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MetodePanggilanActivity : AppCompatActivity() {
    private lateinit var imgKontak: ImageView
    private lateinit var nameKontak: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metode_panggilan)

        imgKontak = findViewById(R.id.image_kontak)
        nameKontak = findViewById(R.id.name_kontak)

        imgKontak.setImageResource(intent.getIntExtra("gambar", 0))
        nameKontak.text = intent.getStringExtra("nama")
    }
}