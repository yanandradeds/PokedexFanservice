package com.example.pokedexfanservice.model

import com.google.gson.annotations.SerializedName


data class OtherModel(
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArt

)

data class OfficialArt(

    val front_default: String

)