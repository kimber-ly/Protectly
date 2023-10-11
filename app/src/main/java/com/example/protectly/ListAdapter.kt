package com.example.protectly

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
class ListAdapter(context: Context, dataArrayList: ArrayList<listKontak?>?) :
    ArrayAdapter<listKontak?>(context, R.layout.list_kontak, dataArrayList!!) {
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var view = view
        val listData = getItem(position)
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_kontak, parent, false)
        }
        val listImage = view!!.findViewById<ImageView>(R.id.listImage)
        val listName = view.findViewById<TextView>(R.id.listName)
        val listNomor = view.findViewById<TextView>(R.id.listnomor)

        listImage.setImageResource(listData!!.image)
        listName.text = listData.name
        listNomor.text = listData.nomor
        return view
    }
}