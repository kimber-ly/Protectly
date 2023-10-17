package com.example.protectly.Kontak
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.protectly.R
import com.google.android.material.tabs.TabLayout

class KontakFragment : Fragment(), View.OnClickListener {
    private lateinit var tab: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var btnSos: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_kontak, container, false)
        btnSos = view.findViewById(R.id.btn_sos)
        btnSos.setOnClickListener(this)

        viewPager = view.findViewById(R.id.viewPager)

        val adapter = PagerAdapterKontak(childFragmentManager)
        viewPager.adapter = adapter

        tab = view.findViewById(R.id.tab_kontak)

        tab.setupWithViewPager(viewPager)

        return view
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_sos -> {
                val intent = Intent(requireContext(), PesanDaruratActivity::class.java)
                startActivity(intent)
            }
        }
    }

}
