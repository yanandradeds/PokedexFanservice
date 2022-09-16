package com.example.pokedexfanservice.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedexfanservice.database.tables.MovesTableModel
import com.example.pokedexfanservice.database.tables.PokemonTableModel
import com.example.pokedexfanservice.database.tables.SpritesTableModel

@Dao
interface PokedexDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: PokemonTableModel): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sprite: SpritesTableModel): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMove(move: MovesTableModel): Long

    @Query("SELECT * FROM Pokemon WHERE id = :id")
    suspend fun get(id: Int) : PokemonTableModel

    @Query("SELECT * FROM Sprites WHERE id = :id")
    suspend fun getSprite(id: Int): SpritesTableModel

    @Query("SELECT * FROM Moves")
    suspend fun getAllMoves(): List<MovesTableModel>

    @Query("SELECT * FROM Pokemon")
    suspend fun getAll() : List<PokemonTableModel>

    @Query("SELECT * FROM Pokemon WHERE id = 151")
    fun livedataDB() : LiveData<PokemonTableModel>

    @Query("SELECT * FROM Sprites")
    suspend fun getSpriteAll(): List<SpritesTableModel>

    @Query("SELECT * FROM Pokemon WHERE firstType = :type OR secondType = :type")
    suspend fun getFiltered(type: String): List<PokemonTableModel>

    @Query("DELETE FROM Pokemon WHERE id > 151")
    fun delete(): Int
}