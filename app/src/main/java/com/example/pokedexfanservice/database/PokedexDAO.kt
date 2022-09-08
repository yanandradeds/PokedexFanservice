package com.example.pokedexfanservice.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.pokedexfanservice.model.PokemonTableModel
import com.example.pokedexfanservice.model.SpriteModel
import com.example.pokedexfanservice.model.SpritesTableModel

@Dao
interface PokedexDAO {

    @Insert
    suspend fun insert(pokemon: PokemonTableModel): Long

    @Insert
    suspend fun insert(sprite: SpritesTableModel): Long

    @Query("SELECT * FROM Pokemon WHERE id = :id")
    suspend fun get(id: Int) : PokemonTableModel

    @Query("SELECT * FROM Sprites WHERE id = :id")
    suspend fun getSprite(id: Int): SpritesTableModel

    @Query("SELECT * FROM Pokemon")
    suspend fun getAll() : List<PokemonTableModel>

    @Query("SELECT * FROM Sprites")
    suspend fun getSpriteAll(): List<SpritesTableModel>

    @Query("SELECT * FROM Pokemon WHERE firstType = :type OR secondType = :type")
    suspend fun getFiltered(type: String): List<PokemonTableModel>

    @Query("DELETE FROM Pokemon WHERE id > 151")
    fun delete(): Int
}