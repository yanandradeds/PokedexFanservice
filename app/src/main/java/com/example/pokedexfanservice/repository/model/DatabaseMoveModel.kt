package com.example.pokedexfanservice.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedexfanservice.appconstants.DatabaseConstants

@Entity(tableName = DatabaseConstants.MOVE_TABLE)
class DatabaseMoveModel (
    @PrimaryKey
    var pathID: Int,
    @ColumnInfo
    var name: String,
    @ColumnInfo
    var power: Int,
    @ColumnInfo
    var pp: Int,
    @ColumnInfo
    var accuracy: Int,
    @ColumnInfo
    var type: String
)