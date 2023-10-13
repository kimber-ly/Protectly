package com.example.protectly

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnLogin: Button
    private lateinit var email: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(this)

        email = findViewById(R.id.edt_email)
        password = findViewById(R.id.edt_password)

        val bundle = intent.extras
        if (bundle != null){
            email.setText(bundle.getString("email"))
            password.setText(bundle.getString("password"))
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_login -> {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}