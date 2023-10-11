package com.example.protectly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.protectly.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        changeFragments(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId){
                R.id.home -> changeFragments(HomeFragment())
                R.id.kontak -> changeFragments(KontakFragment())
                R.id.rekam -> changeFragments(RekamFragment())
                R.id.laporan -> changeFragments(LaporanFragment())
                R.id.edukasi -> changeFragments(EdukasiFragment())
                else -> {  }
            }
            true
        }
    }

    private fun changeFragments(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}