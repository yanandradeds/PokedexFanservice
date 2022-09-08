package com.example.pokedexfanservice.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedexfanservice.constants.DatabaseConstants

@Entity(tableName = DatabaseConstants.SPRITES_TABLE)
class SpritesTableModel {

    @PrimaryKey
    @ColumnInfo
    var id: Int = 0

    @ColumnInfo
    var front_default: ByteArray = byteArrayOf()

    @ColumnInfo
    var official_artwork: ByteArray = byteArrayOf()

}