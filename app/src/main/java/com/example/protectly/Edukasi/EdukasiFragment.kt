package com.example.protectly.Edukasi

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.protectly.R
import java.util.*

class EdukasiFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<EdukasiDataClass>()
    private lateinit var adapter: EdukasiAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edukasi, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        searchView = view.findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        addDataToList()
        adapter = EdukasiAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

        return view
    }

    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = ArrayList<EdukasiDataClass>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(requireContext(), "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
        mList.add(EdukasiDataClass(R.drawable.baseline_arrow_forward, "Kejahatan"))
        mList.add(EdukasiDataClass(R.drawable.baseline_arrow_forward, "Keamanan Fisik"))
        mList.add(EdukasiDataClass(R.drawable.baseline_arrow_forward, "Keamanan Dunia Maya"))
        mList.add(EdukasiDataClass(R.drawable.baseline_arrow_forward, "Panduan Pelaporan"))
        mList.add(EdukasiDataClass(R.drawable.baseline_arrow_forward, "Kepolisian"))
        mList.add(EdukasiDataClass(R.drawable.baseline_arrow_forward, "Penegak Hukum"))
    }
}