package com.example.task_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task_app.R

class RecyclerAdapter(private val data: List<Map<String, String?>>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemName: TextView = view.findViewById(R.id.itemName)
        val itemEmail: TextView = view.findViewById(R.id.itemEmail)
        val itemGender: TextView = view.findViewById(R.id.itemGender)
        val itemCountry: TextView = view.findViewById(R.id.itemCountry)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.itemName.text = "Name: ${item["Name"]}"
        holder.itemEmail.text = "Email: ${item["Email"]}"
        holder.itemGender.text = "Gender: ${item["Gender"]}"
        holder.itemCountry.text = "Country: ${item["Country"]}"
    }

    override fun getItemCount(): Int = data.size
}
