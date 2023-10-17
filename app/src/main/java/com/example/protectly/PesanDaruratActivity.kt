package com.example.protectly

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PesanDaruratActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewLocation: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan_darurat)

        viewLocation = findViewById(R.id.view_location)
        viewLocation.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this@PesanDaruratActivity, LokasiActivity2::class.java)
        startActivity(intent)
    }
}