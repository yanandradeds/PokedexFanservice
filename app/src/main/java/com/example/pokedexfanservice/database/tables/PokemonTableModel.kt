package com.example.pokedexfanservice.database.tables

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedexfanservice.constants.DatabaseConstants
import java.sql.Blob

@Entity(tableName = DatabaseConstants.POKEMON_TABLE)
class PokemonTableModel {

    @ColumnInfo
    @PrimaryKey
    var id: Int = 0

    @ColumnInfo
    var name: String = ""

    @ColumnInfo
    var firstType: String = ""

    @ColumnInfo
    var secondType: String? = ""

}