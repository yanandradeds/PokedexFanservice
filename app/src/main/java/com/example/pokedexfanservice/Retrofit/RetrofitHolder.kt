package com.example.pokedexfanservice.Retrofit

import com.example.pokedexfanservice.constants.DatabaseConstants
import com.example.pokedexfanservice.model.PokemonModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHolder private constructor() {

    //Classe com intuito de estabelecer uma comunicação com API (Pokeapi)
    //Como os dados foram recebidos e salvos no DB a classe esta inutilizada

    companion object {

        private lateinit var retrofitHodler: RetrofitHolder
        private lateinit var retrofit: Retrofit
        private lateinit var service: ServiceGet

        fun instance(): RetrofitHolder {

            if(!Companion::retrofitHodler.isInitialized){

                retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(DatabaseConstants.BASEURL)
                    .build()

                service = retrofit.create(ServiceGet::class.java)
                retrofitHodler = RetrofitHolder()

            }

            return retrofitHodler

        }

    }

    fun get(id: Int): Call<PokemonModel> {

         return service.call(id)

    }

}








