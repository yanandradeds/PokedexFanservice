package com.example.pokedexfanservice.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedexfanservice.appconstants.DatabaseConstants

@Entity(tableName = DatabaseConstants.POKEMON_TABLE)
data class DatabasePokemonModel(
    @PrimaryKey
    var id: Int,
    @ColumnInfo
    var name: String,
    @ColumnInfo
    val sprite: ByteArray
)


