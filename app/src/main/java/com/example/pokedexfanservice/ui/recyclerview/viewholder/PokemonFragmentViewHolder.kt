package com.example.pokedexfanservice.ui.recyclerview.viewholder

import android.graphics.BitmapFactory
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.databinding.RowItemPokemonFragmentBinding
import com.example.pokedexfanservice.repository.model.DatabasePokemonModel

class PokemonFragmentViewHolder(private val binding: RowItemPokemonFragmentBinding): RecyclerView.ViewHolder(binding.root) {

    fun setVisualsComponentsRecyclerViewsRow(pokemon: DatabasePokemonModel){
        if (visualComponentIsNotNull(pokemon)){
            setImage(pokemon)
            setText(pokemon)
        } else {
            enableProgressBar()
        }

    }

    private fun visualComponentIsNotNull(content: DatabasePokemonModel): Boolean{
        return content.name != "" || content.sprite.any()
    }

    private fun setImage(actualPokemonModel: DatabasePokemonModel) {
        val bitmap = BitmapFactory.decodeByteArray(actualPokemonModel.sprite, 0,
            actualPokemonModel.sprite.size)
        binding.imageviewPokemonSprite.setImageBitmap(bitmap)
    }

    private fun setText(actualPokemonModel: DatabasePokemonModel) {
        var text = ""

        if(actualPokemonModel.id < 10) {
            text = binding.root.context.getString(
                R.string.pokemon_fragment_tile_under10,
                actualPokemonModel.id,
                actualPokemonModel.name.replaceFirstChar { it.uppercase() }
            )
        }
        else if(actualPokemonModel.id < 100) {
            text = binding.root.context.getString(
                R.string.pokemon_fragment_tile_under100,
                actualPokemonModel.id,
                actualPokemonModel.name.replaceFirstChar { it.uppercase() }
            )
        }
        else {
            text = binding.root.context.getString(
                R.string.pokemon_fragment_tile_over99,
                actualPokemonModel.id,
                actualPokemonModel.name.replaceFirstChar { it.uppercase() }
            )
        }
        binding.textviewTitlePokemon.text = text
    }

    fun enableProgressBar() {
        //binding.progessbarCircle.visibility = View.VISIBLE
    }
}