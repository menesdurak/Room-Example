package com.menesdurak.roomexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.menesdurak.roomexample.R
import com.menesdurak.roomexample.databinding.DictionaryRowBinding
import com.menesdurak.roomexample.model.Word

class WordAdapter(private val list: List<Word>) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    class WordViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.dictionary_row, parent, false))
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tvRowName).text = list[position].name
        holder.itemView.findViewById<TextView>(R.id.tvRowMeaning).text = list[position].meaning
    }

    override fun getItemCount(): Int = list.size
}