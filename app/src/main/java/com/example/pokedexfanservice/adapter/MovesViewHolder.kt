package com.example.pokedexfanservice.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.constants.TypeImageConstants
import com.example.pokedexfanservice.constants.Types
import com.example.pokedexfanservice.database.tables.MovesTableModel

class MovesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(move: MovesTableModel) {

        val textView: TextView = view.findViewById(R.id.text_move_name)
        textView.text = move.name.replaceFirstChar { it.uppercase() }

        val imageView: ImageView = view.findViewById(R.id.image_moves_frag)
        val enum = Types.valueOf(move.type.uppercase())

        imageView.setImageResource(TypeImageConstants.resourceImageType(enum))
    }
}
