package com.example.protectly.Home.Settings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.protectly.R

class NotificationAdapter (private var mList: List<NotificationData>) :
    RecyclerView.Adapter<NotificationAdapter.LanguageViewHolder>() {

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.text_notif1)
        val subtitle : TextView = itemView.findViewById(R.id.text_notif2)
        val image : ImageView = itemView.findViewById(R.id.gambar_notif)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notivication, parent , false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationAdapter.LanguageViewHolder, position: Int) {
        holder.image.setImageResource(mList[position].image)
        holder.title.text = mList[position].title
        holder.subtitle.text = mList[position].subtitle
    }
    override fun getItemCount(): Int {
        return mList.size
    }

}