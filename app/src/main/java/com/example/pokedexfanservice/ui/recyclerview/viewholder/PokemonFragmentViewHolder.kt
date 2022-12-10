package com.example.pokedexfanservice.ui.recyclerview.viewholder

import android.graphics.BitmapFactory
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.databinding.RowItemPokemonFragmentBinding
import com.example.pokedexfanservice.repository.model.DatabasePokemonModel

class PokemonFragmentViewHolder(private val binding: RowItemPokemonFragmentBinding): RecyclerView.ViewHolder(binding.root) {

    fun setText(pokemon: DatabasePokemonModel){
        if(pokemon.id < 10) {
            val text = binding.root.context.getString(
                R.string.pokemon_fragment_tile_under10,
                pokemon.id,
                pokemon.name.replaceFirstChar { it.uppercase() }
            )

            binding.textviewTitlePokemon.text = text
        } else if(pokemon.id < 100) {
            val text = binding.root.context.getString(
                R.string.pokemon_fragment_tile_under100,
                pokemon.id,
                pokemon.name.replaceFirstChar { it.uppercase() }
            )

            binding.textviewTitlePokemon.text = text

        } else {
            val text = binding.root.context.getString(
                R.string.pokemon_fragment_tile_over99,
                pokemon.id,
                pokemon.name.replaceFirstChar { it.uppercase() }
            )

            binding.textviewTitlePokemon.text = text
        }

        val bitmap = BitmapFactory.decodeByteArray(pokemon.sprite, 0,pokemon.sprite.size)
        binding.imageviewPokemonSprite.setImageBitmap(bitmap)
    }

    fun enableProgressBar() {
        binding.progessbarCircle.visibility = View.VISIBLE
    }
}