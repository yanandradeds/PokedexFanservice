package com.example.pokedexfanservice.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.model.tablemodel.PokemonTableModel

@Dao
interface PokedexDAO {

    @Insert
    fun insert(pokemon : PokemonTableModel): Long

    @Query("SELECT * FROM Pokemon WHERE id = :id")
    fun get(id: String) : PokemonTableModel

    @Query("SELECT * FROM Pokemon")
    fun getAll() : List<PokemonTableModel>
}