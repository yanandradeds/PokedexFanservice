package com.example.pokedexfanservice.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.pokedexfanservice.appconstants.DatabaseConstants

@Entity(tableName = DatabaseConstants.TYPE_TABLE)
data class DatabaseTypeModel (
    @PrimaryKey
    val pokemonID: Int,
    @ColumnInfo
    val type: String,
    @ColumnInfo
    val secondType: String
        )
