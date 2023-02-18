package com.example.pokedexfanservice.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedexfanservice.appconstants.DatabaseConstants

@Entity(tableName = DatabaseConstants.COMPATIBLE_MOVES_TABLE)
class DatabaseCompatibleMovesModel {
    @PrimaryKey(autoGenerate = true)
    var compatibleTableID: Int = 0

    @ColumnInfo
    var pokemonID: Int = 0

    @ColumnInfo
    var moveID: Int = 0
}
