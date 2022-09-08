package com.example.pokedexfanservice.retrofitholder

import com.example.pokedexfanservice.constants.DatabaseConstants
import com.example.pokedexfanservice.model.PokemonModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class RetrofitConnection private constructor() {

    companion object {

        private lateinit var retrofit: Retrofit
        private lateinit var service: Service

        fun singleton(): Retrofit {

            if(!Companion::retrofit.isInitialized) {

                retrofit = Retrofit.Builder()
                    .baseUrl(DatabaseConstants.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()


            }

            return retrofit
        }

    }


}