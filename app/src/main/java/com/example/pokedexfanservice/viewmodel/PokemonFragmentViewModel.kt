package com.example.pokedexfanservice.viewmodel

import android.content.Context
import androidx.lifecycle.*
import com.example.pokedexfanservice.repository.Repository


class PokemonFragmentViewModel(context: Context): ViewModel() {

    private val repo = Repository.instance(context)

    fun requestDataToApi() {
        repo.requestingData(this)
    }

    fun getPokemonsLiveData() = repo.getPokemonsLiveData()

}
