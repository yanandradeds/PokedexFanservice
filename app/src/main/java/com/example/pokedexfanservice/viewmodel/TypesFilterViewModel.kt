package com.example.pokedexfanservice.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexfanservice.constants.Types
import com.example.pokedexfanservice.database.PokedexDatabase
import com.example.pokedexfanservice.model.PokemonTableModel
import com.example.pokedexfanservice.model.SpritesTableModel
import kotlinx.coroutines.launch
import java.util.*

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