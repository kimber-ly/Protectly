package com.example.protectly

import KontakFragment
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MetodePanggilanActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var imgKontak: ImageView
    private lateinit var nameKontak: TextView
    private lateinit var dismissCall: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metode_panggilan)

        imgKontak = findViewById(R.id.image_kontak)
        nameKontak = findViewById(R.id.name_kontak)
        dismissCall = findViewById(R.id.dismiss_call)
        dismissCall.setOnClickListener(this)

        imgKontak.setImageResource(intent.getIntExtra("gambar", 0))
        nameKontak.text = intent.getStringExtra("nama")
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.dismiss_call ->{
                val fragment = KontakFragment()
                val fragmentTransaction = supportFragmentManager.beginTransaction()

            }
        }
    }
}