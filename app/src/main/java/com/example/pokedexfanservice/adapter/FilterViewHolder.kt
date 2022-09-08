package com.example.pokedexfanservice.adapter

import android.graphics.BitmapFactory
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.model.PokemonTableModel
import com.example.pokedexfanservice.model.SpritesTableModel

class FilterViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    fun onBind(pokemon: PokemonTableModel){

        val textView: TextView = view.findViewById(R.id.text_filtered_act_pokemon_name)
        textView.text =
            if(pokemon.id < 10) {
                "00${pokemon.id} ${pokemon.name.replaceFirstChar { it.uppercase() }}"
            } else if (pokemon.id < 100) {
                "0${pokemon.id} ${pokemon.name.replaceFirstChar { it.uppercase() }}"
            } else {
                "${pokemon.id} ${pokemon.name.replaceFirstChar { it.uppercase() }}"
            }

    }

    fun setImage(sprite: SpritesTableModel) {
        val imageView: ImageView = view.findViewById(R.id.image_filtered_act_pokemon)
        imageView.setImageBitmap(
            BitmapFactory.decodeByteArray(
                sprite.front_default,0,sprite.front_default.size
            )
        )
    }

}