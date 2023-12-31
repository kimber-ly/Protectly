package com.example.protectly.Kontak

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapterKontak(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {
        val tabTitles = arrayListOf("Kontak", "Pesan")
        return tabTitles[position]
    }

    override fun getItem(position: Int): Fragment {
        // Return the fragment for each page
        return when (position) {
            0 -> KontakFragment2() // Create FirstFragment class
            1 -> PesanFragment() // Create SecondFragment class
            // Add more cases for additional pages
            else -> KontakFragment2() // A default fragment or handle the case as needed
        }
    }

    override fun getCount(): Int {
        // Return the number of pages in the ViewPager
        return 2 // You can change this to the actual number of pages
    }
}
