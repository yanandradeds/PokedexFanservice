package com.example.pokedexfanservice.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedexfanservice.appconstants.DatabaseConstants

@Entity(tableName = DatabaseConstants.BASESTATS_TABLE)
data class DatabaseBaseStatsPokemonModel (
    @PrimaryKey
    val pokemonID: Int,
    @ColumnInfo
    val hp: Int,
    @ColumnInfo
    val attack: Int,
    @ColumnInfo
    val defense: Int,
    @ColumnInfo
    val specialAttack: Int,
    @ColumnInfo
    val specialDefense: Int,
    @ColumnInfo
    val speed: Int )
