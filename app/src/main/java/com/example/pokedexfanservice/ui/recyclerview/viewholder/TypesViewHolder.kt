package com.example.pokedexfanservice.ui.recyclerview.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.appconstants.TypeImageConstants
import com.example.pokedexfanservice.appconstants.Types


class TypesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {


    fun bind(pos: Int) {

        val textView = view.findViewById<TextView>(R.id.text_title_types)
        val imageView = view.findViewById<ImageView>(R.id.image_types)

        imageView.setImageResource(TypeImageConstants.resourceImageType(Types.values()[pos]))
        textView.text = Types.values()[pos].toString()

    }
}