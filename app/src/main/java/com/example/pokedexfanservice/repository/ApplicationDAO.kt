package com.example.pokedexfanservice.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedexfanservice.repository.model.*

@Dao
interface ApplicationDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(pokemon: DatabasePokemonModel): Long

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(move: DatabaseMoveModel): Long

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(baseStats: DatabaseBaseStatsPokemonModel): Long

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(type: DatabaseTypeModel): Long

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(compatibleMove: DatabaseCompatibleMovesModel): Long

    @Query("SELECT * FROM Pokemon")
    fun getPokemons(): LiveData<List<DatabasePokemonModel>>

    @Query("SELECT * FROM Pokemon")
    fun getPokemonsList(): List<DatabasePokemonModel>

    @Query("SELECT * From Pokemon Where id = :id")
    fun getPokemonById(id: Int): DatabasePokemonModel

    @Query("SELECT * FROM Type WHERE type = :type")
    fun filterListByType(type: String): List<DatabaseTypeModel>

    @Query("SELECT pathID FROM Move WHERE pathID = 165")
    fun lastMove(): Int?

    @Query("SELECT id FROM Pokemon WHERE id = 151")
    fun lastPokemon(): Int?
}