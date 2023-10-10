package com.example.protectly

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LaporanKosong : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnkirim: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan_kosong)

        btnkirim = findViewById(R.id.btn_kirim)
        btnkirim.setOnClickListener(this)
}

    override fun onClick(v: View?){
        when(v?.id){
            R.id.btn_kirim -> {
                val intent = Intent(this@LaporanKosong, StatusLaporanActivity::class.java)
                startActivity(intent)
            }
        }

    }
}