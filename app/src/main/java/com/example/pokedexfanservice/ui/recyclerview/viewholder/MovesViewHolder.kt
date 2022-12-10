package com.example.pokedexfanservice.ui.recyclerview.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.appconstants.TypeImageConstants
import com.example.pokedexfanservice.appconstants.Types
import com.example.pokedexfanservice.repository.model.DatabaseMoveModel

class MovesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(move: DatabaseMoveModel) {

        val textView: TextView = view.findViewById(R.id.text_move_name)
        textView.text = move.name.replaceFirstChar { it.uppercase() }

        val imageView: ImageView = view.findViewById(R.id.image_moves_frag)
        val enum = Types.valueOf(move.type.uppercase())

        imageView.setImageResource(TypeImageConstants.resourceImageType(enum))
    }
}
