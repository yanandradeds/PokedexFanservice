package com.example.pokedexfanservice.viewmodel

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.pokedexfanservice.database.PokedexDatabase
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.model.tablemodel.PokemonTableModel
import com.example.pokedexfanservice.retrofitholder.RetrofitConnection
import com.example.pokedexfanservice.retrofitholder.Service
import com.example.pokedexfanservice.view.PokedexActivityView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StarterViewModel(application: Application) : AndroidViewModel(application) {

    val db = PokedexDatabase.getDataBase(getApplication()).getDAOInterface()

    fun getDataFromAPI() {

        if (databaseDataExists()) {

            for (i in 1..151) {
                val retrofit = RetrofitConnection.singleton()
                val service = retrofit.create(Service::class.java)
                val called = service.getData(i.toString())

                called.enqueue(
                    object : Callback<PokemonModel> {

                        override fun onResponse(
                            call: Call<PokemonModel>,
                            response: Response<PokemonModel>
                        ) {
                            val bodyPokemon = response.body()
                            val pokemon = PokemonTableModel().apply {

                                this.id = id
                                this.name = bodyPokemon!!.name


                                this.front_default = bodyPokemon.sprites.front_default

                                this.official_artwork = bodyPokemon.sprites.other.official_artwork.front_default_artwork

                                for (type in bodyPokemon.typeModel) {

                                    if(type.slot == 2) {
                                        this.secondType = type.typeName.name
                                    }

                                    this.firstType = type.typeName.name

                                }

                            }

                            db.insert(pokemon)
                        }

                        override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
                            t.printStackTrace()
                        }


                    }
                )
            }
        }
    }

     fun getAll() : List<PokemonTableModel> {

        return db.getAll()

    }

    private fun databaseDataExists(): Boolean {

        return try {
            db.get("151")
            true

        } catch (e: Exception) {

            false
        }
    }

}