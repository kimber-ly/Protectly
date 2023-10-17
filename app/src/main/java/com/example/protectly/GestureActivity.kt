package com.example.protectly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.content.Intent


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

