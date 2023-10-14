package com.example.protectly

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapterKontak(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // Return the fragment for each page
        return when (position) {
            0 -> Kontak_Fragment() // Create FirstFragment class
            1 -> Pesan_Fragment() // Create SecondFragment class
            // Add more cases for additional pages
            else -> Kontak_Fragment() // A default fragment or handle the case as needed
        }
    }

    override fun getCount(): Int {
        // Return the number of pages in the ViewPager
        return 2 // You can change this to the actual number of pages
    }
}
