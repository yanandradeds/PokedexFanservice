package com.example.pokedexfanservice.retrofitholder

import com.example.pokedexfanservice.appconstants.DatabaseConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {

    companion object {

        private lateinit var retrofit: Retrofit
        private lateinit var service: PokeApiEndpoints

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