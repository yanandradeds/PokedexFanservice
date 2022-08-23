package com.example.pokedexfanservice.adapter

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.databinding.RecycleViewItemBinding
import com.example.pokedexfanservice.model.tablemodel.PokemonTableModel
import com.example.pokedexfanservice.view.DetailsActivityView
import com.squareup.picasso.Picasso

class PokedexViewHolder(private val binding: RecycleViewItemBinding) : RecyclerView.ViewHolder(binding.root) {


    fun onClickListener(pokemon : PokemonTableModel, context: Context){

        val intent = Intent(context,DetailsActivityView::class.java)
        intent.putExtra("id",pokemon.id)
        intent.putExtra("name",pokemon.name)
        intent.putExtra("front",pokemon.front_default)
        intent.putExtra("artwork",pokemon.official_artwork)
        intent.putExtra("type1",pokemon.firstType)
        intent.putExtra("type2",pokemon.secondType)

        binding.imagePokemonSprite.setOnClickListener {

            context.startActivity(intent)
        }

    }

    fun setItemImage(pokemon: PokemonTableModel){

        Picasso.get().load(pokemon.front_default).resize(300,300).into(
            binding.imagePokemonSprite
        )


        binding.textRowPokemonId.text =
            if(pokemon.id < 10) "00" + pokemon.id.toString()
            else if (pokemon.id < 100) "0" + pokemon.id.toString()
            else pokemon.id.toString()

    }

}