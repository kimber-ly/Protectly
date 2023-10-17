package com.example.protectly.Home.Profile

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.protectly.R

class GestureSaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gesture_save)

        val btnSimpan : Button = findViewById(R.id.btn_save)

        btnSimpan.setOnClickListener{
            val message : String = "Apakah Kamu yakin untuk Menyimpan Gesture ini?"
            showCustomDialogBox(message)
        }
    }

    private fun showCustomDialogBox(message: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_custom_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMessage : TextView = dialog.findViewById(R.id.tvMessage)
        val btnYes : Button = dialog.findViewById(R.id.btnYes)
        val btnNo : Button = dialog.findViewById(R.id.btnNo)

        tvMessage.text = message

        btnYes.setOnClickListener{
            Toast.makeText(this, "Gesture berhasil disimpan!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, ResetGestureActivity::class.java)
            startActivity(intent)
        }

        btnNo.setOnClickListener{
            dialog.dismiss()
        }
        dialog.show()
    }
}