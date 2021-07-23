package com.example.listfragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(val letterId: String, val context: Context) :
    RecyclerView.Adapter<WordAdapter.WordViewHolder>() {
    private val TAG = "WordAdapter"

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button = itemView.findViewById<Button>(R.id.button_item)

    }

    private var filterWord: List<String>


    init {
        // Retrieve the list of words from res/values/arrays.xml
        val words = context.resources.getStringArray(R.array.words).toList()

        filterWord = words
            // Returns items in a collection if the conditional clause is true,
            // in this case if an item starts with the given letter,
            // ignoring UPPERCASE or lowercase.
            .filter { it.startsWith(letterId, ignoreCase = true) }

        Log.d(TAG, "${letterId}: ")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.button.text = filterWord.get(position)
        holder.button.setOnClickListener {
//            var action= LetterListFragmentDirections
//            var action =
//                WordListFragmentDirections.actionWordListFragmentToBlankFragment2(tran = holder.button.toString())
//            holder.itemView.findNavController().navigate(action)
            val uri = Uri.parse("${WordListFragment.SEARCH_PERFIX}t${holder.button.text}")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            context.startActivity(intent)
        }

    }

    override fun getItemCount() = filterWord.size
}
