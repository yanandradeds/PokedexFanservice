package com.example.pokedexfanservice.model

data class EvolutionsModel (
        val id: Int,
        val hasEvolution: Boolean,
        val firstEvolution: PokemonModel?,
        val secondEvolution: PokemonModel?
        )


