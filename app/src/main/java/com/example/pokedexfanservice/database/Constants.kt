package com.example.pokedexfanservice.database

class Constants private constructor(){

    companion object {

        const val BASEURL = "https://pokeapi.co/api/v2/pokemon/"
        const val DATABASE_NAME = "pokedexDB"
        const val VERSION = 1
        const val POKEMON_TABLE = "Pokemon"
        val ALL_COLUMNS = arrayOf("id","name","front","back")
        const val CREATE_TABLE = "CREATE TABLE"
        const val WHERE = "WHERE"
        const val SPRITE_TABLE = "Sprite"
        const val TYPE_TABLE = "Type"


    }

}