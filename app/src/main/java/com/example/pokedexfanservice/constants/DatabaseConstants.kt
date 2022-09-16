package com.example.pokedexfanservice.constants

class DatabaseConstants private constructor(){

    companion object {

        const val BASEURL = "https://pokeapi.co/api/v2/"
        const val DATABASE_NAME = "pokedexDB"
        const val VERSION = 8
        const val POKEMON_TABLE = "Pokemon"
        const val SPRITES_TABLE = "Sprites"
        const val MOVES_TABLE = "Moves"
    }

}