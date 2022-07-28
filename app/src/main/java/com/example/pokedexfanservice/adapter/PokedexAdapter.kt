package com.example.pokedexfanservice.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.databinding.RowBinding
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.model.SpriteModel
import com.example.pokedexfanservice.listener.CustomListener


class PokedexAdapter : RecyclerView.Adapter<PokedexViewHolder>() {

    private var listPokemonModel: ArrayList<PokemonModel> = arrayListOf()
    private var listSpriteModel: ArrayList<SpriteModel> = arrayListOf()
    private lateinit var listener: CustomListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexViewHolder {

        val item = RowBinding.inflate(LayoutInflater.from(parent.context))
        return PokedexViewHolder(item)

    }

    override fun onBindViewHolder(holder: PokedexViewHolder, pos: Int) {

        val pokemon = listPokemonModel[pos]
        val sprite = listSpriteModel[pos]
        val bitmap = BitmapFactory.decodeByteArray(sprite.front_default,0,sprite.front_default.size)

        holder.binding.imagePokemonSprite.setImageBitmap(bitmap)
        holder.setListener(pokemon,sprite,listener)


    }


    override fun getItemCount(): Int {
        return listPokemonModel.size
    }


    fun updateLists(completeListPokemon: ArrayList<PokemonModel>, completeListSprite: ArrayList<SpriteModel>) {
        listPokemonModel = completeListPokemon
        listSpriteModel = completeListSprite

    }

    fun createListener(imageView: ImageView, nameView: TextView, typeView: TextView, descView: TextView) {

        listener = object: CustomListener {

            override fun onClick(spriteModel: SpriteModel, pokemonModel: PokemonModel) {
                val bitmap = BitmapFactory.decodeByteArray (
                    spriteModel.officialArtworkFront,0,spriteModel.officialArtworkFront.size)

                imageView.setImageBitmap(bitmap)
                nameView.text = pokemonModel.name
                typeView.text = pokemonModel.type
                descView.text = pokemonModel.name
            }

        }

    }



}