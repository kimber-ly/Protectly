package com.example.protectly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class ProfileActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnubahprofil: ImageButton
    private lateinit var btnubahpassword: ImageButton
    private lateinit var btnbuatgestur: ImageButton
    private lateinit var btnlengkapidokumen: ImageButton
    private lateinit var btnkeluar: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        btnubahprofil = findViewById(R.id.btn_ubah_profil)
        btnubahprofil.setOnClickListener(this)

        btnubahpassword = findViewById(R.id.btn_ubah_pasword)
        btnubahpassword.setOnClickListener(this)

        btnbuatgestur = findViewById(R.id.btn_buat_gesture)
        btnbuatgestur.setOnClickListener(this)

        btnlengkapidokumen = findViewById(R.id.btn_lengkapi_dokumen)
        btnlengkapidokumen.setOnClickListener(this)

        btnkeluar = findViewById(R.id.btn_keluar)
        btnkeluar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_ubah_profil -> {
                val intent = Intent(this@ProfileActivity, EditProfilActivity::class.java)
                startActivity(intent)
            }
        }
        when(v?.id){
            R.id.btn_ubah_pasword -> {
                val intent = Intent(this@ProfileActivity, EditProfilActivity::class.java)
                startActivity(intent)
            }
        }
        when(v?.id){
            R.id.btn_buat_gesture -> {
                val intent = Intent(this@ProfileActivity, EditProfilActivity::class.java)
                startActivity(intent)
            }
        }
        when(v?.id){
            R.id.btn_lengkapi_dokumen -> {
                val intent = Intent(this@ProfileActivity, EditProfilActivity::class.java)
                startActivity(intent)
            }
        }
        when(v?.id){
            R.id.btn_keluar -> {
                val intent = Intent(this@ProfileActivity, EditProfilActivity::class.java)
                startActivity(intent)
            }
        }
    }

}