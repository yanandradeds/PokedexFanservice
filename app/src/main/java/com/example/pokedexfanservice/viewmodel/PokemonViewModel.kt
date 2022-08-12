package com.example.pokedexfanservice.viewmodel

import android.app.Application
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Environment
import android.widget.ImageView
import androidx.core.database.getStringOrNull
import androidx.lifecycle.AndroidViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableResource
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.constants.DatabaseConstants
import com.example.pokedexfanservice.database.PokedexRepository
import com.example.pokedexfanservice.constants.PokemonConstants
import com.example.pokedexfanservice.constants.SpriteConstants
import com.example.pokedexfanservice.databinding.ActivityMainBinding
import com.example.pokedexfanservice.model.*
import com.example.pokedexfanservice.view.MainActivityView
import java.io.File


class PokemonViewModel (application: Application)  : AndroidViewModel(application){

    private val pokedexRepository = PokedexRepository.getInstance(application)


    // Retorna lista com todos PokemonModel
    fun getAllPokemonModel(): ArrayList<PokemonModel> {

        val listPokemonModel = arrayListOf<PokemonModel>()
        val cursor = pokedexRepository.select(DatabaseConstants.POKEMON_TABLE, null, null, null ,null ,null ,null)

        while(cursor.moveToNext()) {

            val indexId = cursor.getColumnIndex(PokemonConstants.ID_COLUMN)
            val indexName = cursor.getColumnIndex(PokemonConstants.NAME_COLUMN)
            val indexType = cursor.getColumnIndex(PokemonConstants.TYPE_COLUMN)
            val indexTypeTwo = cursor.getColumnIndex(PokemonConstants.TYPE2_COLUMN)

            //indexID usados duas vezes para ja manter a ordem no arraylist

            listPokemonModel.add(PokemonModel(
                cursor.getInt(indexId),
                cursor.getString(indexName),
                cursor.getString(indexType),
                cursor.getStringOrNull(indexTypeTwo)
            ))

        }

        return listPokemonModel
    }

    //Retorna lista com todas SpritesModel
    fun getAllSpriteModel(): ArrayList<SpriteModel> {

        val arrayColumn = arrayOf(
            SpriteConstants.ID_COLUMN,
            SpriteConstants.FRONT_DEFAULT,
            SpriteConstants.OFFICIAL_ARTWORK_COLUMN)

        val listSpriteModel = arrayListOf<SpriteModel>()
        val cursor = pokedexRepository.select(
            DatabaseConstants.SPRITE_TABLE,
            arrayColumn,null, null, null, null, null)

        while(cursor.moveToNext()) {

            val indexId = cursor.getColumnIndex(SpriteConstants.ID_COLUMN)
            val indexFront = cursor.getColumnIndex(SpriteConstants.FRONT_DEFAULT)
            val indexOfficialArt = cursor.getColumnIndex(SpriteConstants.OFFICIAL_ARTWORK_COLUMN)

            listSpriteModel.add(
                SpriteModel(
                    cursor.getInt(indexId),
                    cursor.getBlob(indexFront),
                    cursor.getBlob(indexOfficialArt)
            ))

        }

        return listSpriteModel
    }

    //Carrega imagem da tela principal
    fun setPrincipalImageFirstTime(view : ImageView) {

        val sprite = getSpritePokemon(1,SpriteConstants.OFFICIAL_ARTWORK_COLUMN)
        val bitmap = BitmapFactory.decodeByteArray(sprite,0,sprite.size)
        view.setImageBitmap(bitmap)

    }

    //Retorna SpriteModel com base no id e coluna (front_default ou official_artwork)
    fun getSpritePokemon(id: Int, column: String): ByteArray {

        val cursor = pokedexRepository.select(DatabaseConstants.SPRITE_TABLE, arrayOf(column),"id = $id",null,null,null,null)
        cursor.moveToNext()

        return cursor.getBlob(0)

    }

    fun getPokemonModel() {

    }



    /*  Busca e insere os dados da PokeAPI no banco de dados,
    usado na primeira execução do aplicativo e depois desativado

    private val holderConnection = RetrofitHolder.request()

    fun getDataInAPI() {

        var count = 1

        while (count <= 151) {

                holderConnection.get(count).enqueue(callback())
                count++
        }

    }

    //Responsavel por inserir os dados no DB

    // Models desatualizados!

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
