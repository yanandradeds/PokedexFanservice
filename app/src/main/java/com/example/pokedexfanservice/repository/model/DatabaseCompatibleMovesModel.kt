package com.example.pokedexfanservice.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedexfanservice.appconstants.DatabaseConstants

@Entity(tableName = DatabaseConstants.COMPATIBLE_MOVES_TABLE)
data class DatabaseCompatibleMovesModel (
    @PrimaryKey
    val pokemonID: Int,
    @ColumnInfo
    val moveID: Int
        )
