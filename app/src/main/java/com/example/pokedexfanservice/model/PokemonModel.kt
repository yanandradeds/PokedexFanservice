package com.example.pokedexfanservice.model



import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

data class PokemonModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("sprites")
    val sprites: SpriteModel,

    @SerializedName("types")
    val typeModel : List<TypeModel>,

    @SerializedName("moves")
    val moves: List<MovesPokemonModel>
    )


data class SpriteModel(
    @SerializedName("front_default")
    val front_default: String,
    @SerializedName("other")
    val other : OtherModel
    )

data class OtherModel (
    @SerializedName("official-artwork")
    val official_artwork : OfficialArtwork
    )

data class OfficialArtwork(
    @SerializedName("front_default")
    val front_default_artwork: String
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

