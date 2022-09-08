package com.example.pokedexfanservice.adapter

import android.graphics.BitmapFactory
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.model.SpritesTableModel


class PokedexViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(sprite: SpritesTableModel) {

        val imageView = view.findViewById<ImageView>(R.id.image_pokemon_sprite)
        val textView = view.findViewById<TextView>(R.id.text_row_pokemon_id)
        val bitmap = BitmapFactory.decodeByteArray(
            sprite.front_default,0,sprite.front_default.size
        )

        imageView.setImageBitmap(bitmap)

        textView.text =
            if(sprite.id < 10) "00" + sprite.id.toString()
            else if (sprite.id < 100) "0" + sprite.id.toString()
            else sprite.id.toString()

    }

}