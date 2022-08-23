package com.example.pokedexfanservice.model.tablemodel

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedexfanservice.constants.DatabaseConstants
import java.sql.Blob

@Entity(tableName = DatabaseConstants.POKEMON_TABLE)
class PokemonTableModel {

    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo
    var name: String = ""

    @ColumnInfo
    var firstType: String = ""

    @ColumnInfo
    var secondType: String? = ""

    @ColumnInfo
    var official_artwork: String = ""

    @ColumnInfo
    var front_default: String = ""
}