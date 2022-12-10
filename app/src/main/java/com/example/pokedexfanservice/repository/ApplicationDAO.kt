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

}