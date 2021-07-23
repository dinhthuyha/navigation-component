package com.example.listfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class LetterAdapter : RecyclerView.Adapter<LetterAdapter.WordViewHolder>() {
    private val list = ('a').rangeTo('z').toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return WordViewHolder(itemView)
    }


    override fun getItemCount() = list.size
    class WordViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_item)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val item = list.get(position)
        holder.button.text = item.toString()
        holder.button.setOnClickListener {
            val action =
                LetterListFragmentDirections.actionLetterListFragmentToWordListFragment(letter = holder.button.text.toString())
            holder.view.findNavController().navigate(action)
        }
    }
}