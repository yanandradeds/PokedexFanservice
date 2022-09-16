package com.example.pokedexfanservice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.pokedexfanservice.constants.Types
import com.example.pokedexfanservice.database.PokedexDatabase
import com.example.pokedexfanservice.database.tables.PokemonTableModel
import com.example.pokedexfanservice.database.tables.SpritesTableModel

class TypesFilterViewModel(application: Application): AndroidViewModel(application) {

    private val database = PokedexDatabase.getDataBase(application).getDAOInterface()
    private val listPokemonFiltered = mutableListOf<PokemonTableModel>()
    private val listSpriteFiltered = mutableListOf<SpritesTableModel>()

    suspend fun attachDataToArray(enum: Types) {
        val list = database.getFiltered(enum.name.lowercase())

        for (item in list) {
            listPokemonFiltered.add(item)
            listSpriteFiltered.add(database.getSprite(item.id))

        }

    }

    suspend fun getListPokemon(): List<PokemonTableModel> = listPokemonFiltered
    suspend fun getListSprite(): List<SpritesTableModel> = listSpriteFiltered

}