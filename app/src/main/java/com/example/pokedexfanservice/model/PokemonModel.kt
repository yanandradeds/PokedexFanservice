package com.example.pokedexfanservice.model

import com.google.gson.annotations.SerializedName

data class PokemonModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("sprites")
    val spritesHeadTree: SpritesHeadTree,

    @SerializedName("types")
    val typeModel : List<TypeModel>,

    @SerializedName("moves")
    val moves: List<MovesPokemonModel>,

    @SerializedName("stats")
    val stats: List<StatsHeadTree>
    )


data class SpritesHeadTree(
    @SerializedName("other")
    val spritesList : SpritesList

    )


data class SpritesList (
    @SerializedName("official-artwork")
    val spriteOfficial: SpriteOfficial
    )

data class SpriteOfficial(
    @SerializedName("front_default")
    val urlSprite: String
)

data class TypeModel(
    @SerializedName("slot")
    val slot : Int,
    @SerializedName("type")
    val typeName : TypeNameModel

)

data class TypeNameModel(
    @SerializedName("name")
    val name: String
)

data class StatsHeadTree(
    @SerializedName("base_stat")
    val valueStat: Int,
)

