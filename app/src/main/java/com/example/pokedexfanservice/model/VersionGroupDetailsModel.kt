package com.example.pokedexfanservice.model

import com.google.gson.annotations.SerializedName

data class VersionGroupDetailsModel(

    @SerializedName("level_learned_at")
    val level: Int,
    @SerializedName("move_learn_method")
    val method: MoveLearnMethod,
    @SerializedName("version_group")
    val version: VersionGroup
    )

data class MoveLearnMethod(
    val name: String
    )

data class VersionGroup (
    val name: String
    )

