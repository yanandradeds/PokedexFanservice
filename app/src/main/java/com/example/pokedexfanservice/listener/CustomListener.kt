package com.example.pokedexfanservice.listener

import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.model.SpriteModel

interface CustomListener {

    fun onClick(spriteModel: SpriteModel, pokemonModel: PokemonModel)

}