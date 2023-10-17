package com.example.protectly.Home.Profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.content.Intent
import com.example.protectly.R


class GestureActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var btngesture: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gesture)
        btngesture = findViewById(R.id.btngesture)
        btngesture.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btngesture -> {
                val intent = Intent(this@GestureActivity, GestureSaveActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

