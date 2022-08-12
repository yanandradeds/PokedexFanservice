package com.example.pokedexfanservice.listener

import android.content.Context
import android.content.Intent
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.model.SpriteModel

interface CustomListener {

    fun onClick(spriteModel: SpriteModel, pokemonModel: PokemonModel, context: Context, intent: Intent)

}