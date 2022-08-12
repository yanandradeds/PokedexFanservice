package com.example.pokedexfanservice.adapter

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.databinding.RowBinding
import com.example.pokedexfanservice.databinding.RowBinding.inflate
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.model.SpriteModel
import com.example.pokedexfanservice.listener.CustomListener
import com.example.pokedexfanservice.view.DetailsActivityView
import com.example.pokedexfanservice.view.MainActivityView


class PokedexAdapter : RecyclerView.Adapter<PokedexViewHolder>() {

    private var listPokemonModel: ArrayList<PokemonModel> = arrayListOf()
    private var listSpriteModel: ArrayList<SpriteModel> = arrayListOf()
    private lateinit var context: Context
    private lateinit var binding: RowBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexViewHolder {

        context = parent.context
        binding = inflate(LayoutInflater.from(context))
        return PokedexViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PokedexViewHolder, pos: Int) {

        val pokemon = listPokemonModel[pos]
        val sprite = listSpriteModel[pos]
        val imageView = holder.binding.imagePokemonSprite
        val bitmap = BitmapFactory.decodeByteArray(sprite.front_default,0,sprite.front_default.size)


        imageView.setImageBitmap(bitmap)
        holder.setListener(pokemon,sprite,customListener,context)

    }


    override fun getItemCount(): Int {
        return listPokemonModel.size
    }

    private val customListener = object : CustomListener {

        override fun onClick(sprite : SpriteModel, pokemon: PokemonModel, context: Context, intent: Intent) {

            context.startActivity(intent)

        }

    }


    fun updateLists(completeListPokemon: ArrayList<PokemonModel>, completeListSprite: ArrayList<SpriteModel>) {
        listPokemonModel = completeListPokemon
        listSpriteModel = completeListSprite


    }


}