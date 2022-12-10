package com.example.pokedexfanservice.ui.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.databinding.RowItemPokemonFragmentBinding
import com.example.pokedexfanservice.repository.model.DatabasePokemonModel
import com.example.pokedexfanservice.ui.recyclerview.viewholder.PokemonFragmentViewHolder

class PokemonFragmentAdapter(): RecyclerView.Adapter<PokemonFragmentViewHolder>() {

    private var pokemonList: List<DatabasePokemonModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonFragmentViewHolder {
        return PokemonFragmentViewHolder(
            RowItemPokemonFragmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PokemonFragmentViewHolder, position: Int) {

        try {
            holder.setText(pokemonList[position])
        } catch (_: IndexOutOfBoundsException){
            holder.enableProgressBar()
        }

    }

    override fun getItemCount(): Int {
        return 151
    }

    fun updateData(list: List<DatabasePokemonModel>) {
        pokemonList = list
        this.notifyDataSetChanged()
    }

}