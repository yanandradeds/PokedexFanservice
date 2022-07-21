package com.example.pokedexfanservice.Retrofit

import com.example.pokedexfanservice.model.PokemonModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ServiceGet {

    @GET("{id}")
    fun call(@Path("id") id: Int): Call<PokemonModel>


}