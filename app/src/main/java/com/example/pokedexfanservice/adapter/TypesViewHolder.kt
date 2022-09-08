package com.example.pokedexfanservice.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.constants.TypeImageConstants
import com.example.pokedexfanservice.constants.Types

import com.example.pokedexfanservice.view.TypesFilterActivityView
import com.example.pokedexfanservice.view.TypesFragmentView


class TypesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {


    fun bind(pos: Int) {

        val textView = view.findViewById<TextView>(R.id.text_title_types)
        val imageView = view.findViewById<ImageView>(R.id.image_types)

        imageView.setImageResource(TypeImageConstants.resourceImageType(Types.values()[pos]))
        textView.text = Types.values()[pos].toString()

        imageView.setOnClickListener {
            val intent = Intent(view.context,TypesFilterActivityView::class.java)
            intent.putExtra("enum",Types.values()[pos])
            view.context.startActivity(intent)

        }
    }
}