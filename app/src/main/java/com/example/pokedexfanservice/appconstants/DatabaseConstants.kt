package com.example.pokedexfanservice.appconstants

class DatabaseConstants private constructor(){

    companion object {

        const val BASEURL = "https://pokeapi.co/api/v2/"
        const val DATABASE_NAME = "pokedexDB"
        const val VERSION = 5
        const val POKEMON_TABLE = "Pokemon"
        const val MOVE_TABLE = "Move"
        const val BASESTATS_TABLE = "Base Stats"
        const val TYPE_TABLE = "Type"
        const val COMPATIBLE_MOVES_TABLE ="Compatible Moves"
    }

}