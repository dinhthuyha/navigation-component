package com.example.listfragment

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(
    itemView: View

    ) : RecyclerView.ViewHolder(itemView) {

    var button_item: Button= itemView.findViewById(R.id.button_item)
}