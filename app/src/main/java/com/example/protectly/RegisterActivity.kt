package com.example.protectly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnDaftar: Button
    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnDaftar = findViewById(R.id.btn_daftar)
        btnDaftar.setOnClickListener(this)

        name = findViewById(R.id.edt_name)
        email = findViewById(R.id.edt_email)
        password = findViewById(R.id.edt_password)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_daftar -> {
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                val bundle = Bundle()
                bundle.putString("name", name.text.toString())
                bundle.putString("email", email.text.toString())
                bundle.putString("password", password.text.toString())
                intent.putExtras(bundle)

                startActivity(intent)
            }
        }
    }
}