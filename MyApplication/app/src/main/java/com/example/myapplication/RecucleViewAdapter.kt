package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecucleViewAdapter (context: Context?,val data: MutableList<Spisok>):
    RecyclerView.Adapter<RecucleViewAdapter.RecucleViewHolder>() {
    private val layoutInflater: LayoutInflater =
        android.view.LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecucleViewHolder {
        val view: View = layoutInflater.inflate(R.layout.item_spisock, parent, false)
        return RecucleViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecucleViewHolder, position: Int) {
        val item = data[position]
        holder.deloTextView.text = item.business
        holder.timeTextView.text = item.time
        holder.dataTextView.text = item.data
    }

    override fun getItemCount(): Int = data.size
    inner class RecucleViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var deloTextView: TextView = item.findViewById(R.id.tvDelo)
        var timeTextView: TextView = item.findViewById(R.id.tvTime)
        var dataTextView: TextView = item.findViewById(R.id.tvData)
    }
}
