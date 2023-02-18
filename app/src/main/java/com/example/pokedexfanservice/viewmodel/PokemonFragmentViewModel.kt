package com.example.pokedexfanservice.viewmodel

import android.content.Context
import androidx.lifecycle.*
import com.example.pokedexfanservice.repository.Repository
import com.example.pokedexfanservice.repository.model.DatabasePokemonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class PokemonFragmentViewModel(context: Context): ViewModel() {

    private val repo = Repository.instance(context)
    private val mListPokemon = MutableLiveData<List<DatabasePokemonModel>>()

    fun requestDataToApi() {
        repo.requestingData(this)
        viewModelScope.launch(){
            val list = repo.getPokemonList()
            mListPokemon.value = list
        }
    }

    fun getPokemonsLiveData() = repo.getPokemonsLiveData()

    fun pokemonList() : MutableLiveData<List<DatabasePokemonModel>> = mListPokemon

}
