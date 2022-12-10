package com.example.pokedexfanservice.retrofitholder

import com.example.pokedexfanservice.model.MovesModel
import com.example.pokedexfanservice.model.PokemonModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiEndpoints {

    @GET("pokemon/{id}")
    fun getPokemon(@Path("id") id: Int): Call<PokemonModel>

    @GET("move/{id}")
    fun getMove(@Path("id") id: Int): Call<MovesModel>

}