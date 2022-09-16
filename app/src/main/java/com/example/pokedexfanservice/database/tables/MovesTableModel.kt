package com.example.pokedexfanservice.database.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedexfanservice.constants.DatabaseConstants

@Entity(tableName = DatabaseConstants.MOVES_TABLE)
class MovesTableModel {

    @PrimaryKey
    @ColumnInfo
    var id: Int = 0
    @ColumnInfo
    var name: String = ""
    @ColumnInfo
    var power: Int = 0
    @ColumnInfo
    var pp: Int = 0
    @ColumnInfo
    var accuracy: Int = 0
    @ColumnInfo
    var type: String = ""

}