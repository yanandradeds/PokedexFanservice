package com.example.pokedexfanservice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexfanservice.database.PokedexDatabase
import com.example.pokedexfanservice.database.tables.MovesTableModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovesFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val database = PokedexDatabase.getDataBase(application).getDAOInterface()

    suspend fun returnMoves(): List<MovesTableModel> {
        return database.getAllMoves()
    }

}