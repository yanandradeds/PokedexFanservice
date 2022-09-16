package com.example.pokedexfanservice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.database.tables.PokemonTableModel
import com.example.pokedexfanservice.database.tables.SpritesTableModel

class FilterAdapter(sprites: List<SpritesTableModel>, pokemons: List<PokemonTableModel>): RecyclerView.Adapter<FilterViewHolder>() {

    private val listPokemon = pokemons
    private val listSprite = sprites

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.row_item_filtered_activity,parent,false)
        return FilterViewHolder(layout)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.onBind(listPokemon[position])
        holder.setImage(listSprite[position])
    }

    override fun getItemCount(): Int {
        return listPokemon.size
    }
}