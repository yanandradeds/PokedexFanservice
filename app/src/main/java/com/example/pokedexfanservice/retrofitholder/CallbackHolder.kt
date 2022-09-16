package com.example.pokedexfanservice.retrofitholder

import com.example.pokedexfanservice.model.PokemonModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallbackHoer(): Callback<PokemonModel> {

    override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {


    }

    override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
        t.printStackTrace()
    }

}