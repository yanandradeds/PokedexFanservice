package com.example.pokedexfanservice.model

import com.google.gson.annotations.SerializedName

data class MovesPokemonModel(
    @SerializedName("move")
    val move: Move,
    @SerializedName("version_group_details")
    val version : List<VersionGroupDetailsModel>
)

data class Move(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
