package com.example.pokedexfanservice.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexfanservice.repository.ApplicationDatabase
import com.example.pokedexfanservice.repository.Repository
import com.example.pokedexfanservice.repository.model.DatabasePokemonModel
import kotlinx.coroutines.launch

class TypesFilterViewModel(context: Context): ViewModel() {

    private val repository = Repository.instance(context)
    private val listPokemonFiltered = MutableLiveData<List<DatabasePokemonModel>>()

    fun filterListPokemon(type: String){
        viewModelScope.launch {
            val list = repository.listPokemonFilteredByType(type.lowercase())
            listPokemonFiltered.value = list
        }
    }

    fun getMutableLiveDataListPokemon(): MutableLiveData<List<DatabasePokemonModel>> {
        return listPokemonFiltered
    }

}