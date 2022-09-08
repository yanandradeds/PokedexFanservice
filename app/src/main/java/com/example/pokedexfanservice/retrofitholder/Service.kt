package com.example.pokedexfanservice.retrofitholder

import com.example.pokedexfanservice.model.PokemonModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    @GET("{id}")
    fun getData(@Path("id") id: Int): Call<PokemonModel>

}