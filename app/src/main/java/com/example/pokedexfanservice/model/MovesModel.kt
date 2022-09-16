package com.example.pokedexfanservice.model

import com.google.gson.annotations.SerializedName

data class MovesModel(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("power")
    val power: Int,

    @SerializedName("pp")
    val pp: Int,

    @SerializedName("accuracy")
    val accuracy: Int,

    @SerializedName("type")
    val type: MoveTypeModel
)

data class MoveTypeModel(
    @SerializedName("name")
    val typeName: String
)