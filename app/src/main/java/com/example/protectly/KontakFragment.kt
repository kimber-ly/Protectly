package com.example.protectly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.protectly.databinding.FragmentKontakBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [KontakFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("UNREACHABLE_CODE")
class KontakFragment : Fragment() {

    private lateinit var binding: FragmentKontakBinding

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kontak, container, false)
        val listView = binding.listView

        val contactList = listOf("name", "nomor", "image")

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, contactList)
        listView.adapter = adapter


        listView.setOnItemClickListener { parent, view, position, id ->
            val inflater = LayoutInflater.from(context)
            val kontakItemView = inflater.inflate(R.layout.list_kontak, null)
        }

            return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            KontakFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}