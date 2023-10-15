package com.example.protectly

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private lateinit var profile: ImageView
    private lateinit var settings: ImageView
    private lateinit var map: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        profile = view.findViewById(R.id.img_profile)
        settings = view.findViewById(R.id.icon_settings)
        map = view.findViewById(R.id.map_img)

        profile.setOnClickListener(this)
        settings.setOnClickListener(this)
        map.setOnClickListener(this)
        return view

    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.img_profile -> {
                val intent = Intent(requireActivity(), ProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.icon_settings -> {
                val intent = Intent(requireActivity(), SettingsActivity::class.java)
                startActivity(intent)
            }
            R.id.map_img -> {
                val intent = Intent(requireActivity(), LokasiActivity2::class.java)
                startActivity(intent)
            }
        }
    }

}