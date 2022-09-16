package com.example.pokedexfanservice.model

import com.google.gson.annotations.SerializedName

//Classe Modelo que estrutura todos os movimentos que um pokemon possui,
//utilizado para pegar os dados na API.



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


/* Exemplo de um json em que esta classe esta estruturada
{
    moves : [

        0:{
            move:{
                name: dançar
                url: www.google.com/move/dançar
            }
            version_grupo_details: []  //Lista com detalhes de cada versao dos jogos
        }

        1: {}
        2: {}
        3: {}
        ...n's itens
    ]
}
 */