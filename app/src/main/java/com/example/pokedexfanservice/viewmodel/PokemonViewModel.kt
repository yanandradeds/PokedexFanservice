package com.example.pokedexfanservice.viewmodel

import android.app.Application
import androidx.core.database.getStringOrNull
import androidx.lifecycle.AndroidViewModel
import com.example.pokedexfanservice.database.Constants
import com.example.pokedexfanservice.database.PokedexRepository
import com.example.pokedexfanservice.database.SpriteConstants
import com.example.pokedexfanservice.model.*


class PokemonViewModel (application: Application)  : AndroidViewModel(application){

    private val pokedexRepository = PokedexRepository.getInstance(application)

    // Retorna lista com todos PokemonModel até o numero 151
    fun getAll(): List<PokemonModel> {

        val listPKM = ArrayList<PokemonModel>()
        val cursorTablePokemon = pokedexRepository.select(Constants.POKEMON_TABLE, null, null, null,null,null,null)
        val cursorTableSprite = pokedexRepository.select(Constants.SPRITE_TABLE, null, null, null,null,null,null)
        val cursorTableType = pokedexRepository.select(Constants.TYPE_TABLE, null, null, null,null,null,null)
        pokedexRepository.newTable()

        while(cursorTablePokemon.moveToNext()){
            cursorTableSprite.moveToNext()
            cursorTableType.moveToNext()

            val indexId = cursorTablePokemon.getColumnIndex("id")
            val indexName = cursorTablePokemon.getColumnIndex("name")
            val indexBackDefault = cursorTableSprite.getColumnIndex(SpriteConstants.BACK_DEFAULT)
            val indexBackFemale: Int = cursorTableSprite.getColumnIndex(SpriteConstants.BACK_FEMALE)
            val indexBackShiny = cursorTableSprite.getColumnIndex(SpriteConstants.BACK_SHINY)
            val indexBackShinyFemale = cursorTableSprite.getColumnIndex(SpriteConstants.BACK_SHINY_FEMALE)
            val indexFrontDefault = cursorTableSprite.getColumnIndex(SpriteConstants.FRONT_DEFAULT)
            val indexFrontFemale = cursorTableSprite.getColumnIndex(SpriteConstants.FRONT_FEMALE)
            val indexFrontShiny = cursorTableSprite.getColumnIndex(SpriteConstants.FRONT_SHINY)
            val indexFrontShinyFemale = cursorTableSprite.getColumnIndex(SpriteConstants.FRONT_SHINY_FEMALE)
            val indexArtwork = cursorTableSprite.getColumnIndex(SpriteConstants.OFFICIAL_ARTWORK_COLUMN)

            val nextSpritePokemon = SpriteModel(
                cursorTableSprite.getString(indexBackDefault),
                cursorTableSprite.getStringOrNull(indexBackFemale),
                cursorTableSprite.getString(indexBackShiny),
                cursorTableSprite.getStringOrNull(indexBackShinyFemale),
                cursorTableSprite.getString(indexFrontDefault),
                cursorTableSprite.getStringOrNull(indexFrontFemale),
                cursorTableSprite.getString(indexFrontShiny),
                cursorTableSprite.getStringOrNull(indexFrontShinyFemale),
                OtherModel(
                    OfficialArt( cursorTableSprite.getString(indexArtwork) )
                )
            )

            val indexNameType = cursorTableType.getColumnIndex("firstType")
            val indexSecondNameType = cursorTableType.getColumnIndex("secondType")


            val nextTypePokemon = ArrayList<TypeModel>()

            nextTypePokemon.add( TypeModel(
                TypeName( cursorTableType.getString(indexNameType) )
            ) )

            if(cursorTableType.getString(indexSecondNameType) != "") {

                nextTypePokemon.add( TypeModel (
                    TypeName( cursorTableType.getString(indexSecondNameType) )
                ) )

            }

            val nextPokemon = PokemonModel(
                cursorTablePokemon.getInt(indexId),
                cursorTablePokemon.getString(indexName),
                nextSpritePokemon,
                nextTypePokemon
            )

            listPKM.add(nextPokemon)

        }

        return listPKM

    }

    fun getSpritePokemon(id: Int, column: String): String {

        val cursor = pokedexRepository.select(Constants.SPRITE_TABLE, arrayOf(column),null,null,null,null,null)
        cursor.moveToNext()

        return cursor.getString(0)

    }

    /*  Busca e insere os dados da PokeAPI no banco de dados,
    usado na primeira execução do aplicativo e depois desativado

    private val holderConnection = RetrofitHolder.request()

    fun getDataInAPI() {

        var count = 1

        if(false) {

            pokedexRepository.execQueryDB("DELETE FROM Pokemon")
            pokedexRepository.execQueryDB("DELETE FROM Sprite")
            pokedexRepository.execQueryDB("DELETE FROM Type")
            pokedexRepository.execQueryDB("ALTER TABLE Sprite ADD COLUMN official_artwork")

            while (count <= 151) {

                holderConnection.get(count).enqueue(callback())
                count++
            }

        }

    }

    //Responsavel por inserir os dados no DB

    private fun callback() : Callback<PokemonModel>{

        return object: Callback<PokemonModel>{

            override fun onResponse(call: Call<PokemonModel>, r: Response<PokemonModel>) {


                val pokemonModel = PokemonModel(
                    r.body()!!.id,
                    r.body()!!.name,
                    r.body()!!.sprites,
                    r.body()!!.types
                )

                pokedexRepository.insertInto(pokemonModel)

            }

            override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
                println("ON FAILURE METHOD")
            }

        }

    }

    */

}
