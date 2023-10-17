package com.example.protectly

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KontakAdapter(private var kontakList: ArrayList<ListKontak>) :
    RecyclerView.Adapter<KontakAdapter.KontakViewHolder>() {
//
    inner class KontakViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image : ImageView = itemView.findViewById(R.id.listImage1)
        val nomor : TextView = itemView.findViewById(R.id.listnomor1)
        val nama : TextView = itemView.findViewById(R.id.listName1)
        val call: ImageView = itemView.findViewById(R.id.btn_call)
        val message: ImageView = itemView.findViewById(R.id.btn_pesan)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KontakViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_kontak , parent , false)
        return KontakViewHolder(view)
    }

    override fun onBindViewHolder(holder: KontakViewHolder, position: Int) {
        holder.image.setImageResource(kontakList[position].image)
        holder.nama.text = kontakList[position].name
        holder.nomor.text = kontakList[position].nomor

        holder.call.setOnClickListener{
            val context = holder.itemView.context
            val intent = Intent(context, MetodePanggilanActivity::class.java)
            val bundle = Bundle()
            bundle.putInt("gambar", kontakList[position].image)
            bundle.putString("nama", kontakList[position].name)

            intent.putExtras(bundle)
            context.startActivity(intent)
        }
        holder.message.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ChatActivity::class.java)
            val bundle = Bundle()
            bundle.putInt("gambar", kontakList[position].image)
            bundle.putString("nama", kontakList[position].name)

            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return kontakList.size
    }
}