package com.example.pokedexfanservice.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.databinding.ActivityMainBinding
import com.example.pokedexfanservice.databinding.RowBinding
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.model.SpriteModel
import com.example.pokedexfanservice.listener.CustomListener
import com.example.pokedexfanservice.view.DetailsActivityView
import com.example.pokedexfanservice.view.MainActivityView
import com.example.pokedexfanservice.viewmodel.PokemonViewModel

class PokedexViewHolder(internal val binding: RowBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setListener(pokemon : PokemonModel, sprite: SpriteModel, listener: CustomListener, context: Context){

        binding.imagePokemonSprite.setOnClickListener {

            val intent = Intent(context,DetailsActivityView::class.java)
            intent.putExtra("artwork",sprite.officialArtworkFront)
            intent.putExtra("front",sprite.front_default)
            intent.putExtra("id",pokemon.id)
            intent.putExtra("name",pokemon.name)
            intent.putExtra("type",pokemon.type)

            if(pokemon.type2 != null) {
                intent.putExtra("type2",pokemon.type2)
            }

            listener.onClick(sprite,pokemon,context,intent)

        }

    }

}