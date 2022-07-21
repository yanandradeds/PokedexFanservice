package com.example.pokedexfanservice.model


data class PokemonModel(
    val id: Int,
    val name: String,
    val sprites: SpriteModel,
    val types: ArrayList<TypeModel>
    )