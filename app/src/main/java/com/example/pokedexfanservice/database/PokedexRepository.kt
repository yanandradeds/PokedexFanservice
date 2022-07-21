package com.example.pokedexfanservice.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteException
import com.example.pokedexfanservice.model.PokemonModel

class PokedexRepository private constructor(ctx: Context) {

    private val pokedexDatabase = PokedexDatabase(ctx)
    private val dbWriter = pokedexDatabase.writableDatabase
    private val dbReadable = pokedexDatabase.readableDatabase

    companion object {

        private lateinit var repository: PokedexRepository

        fun getInstance(ctx: Context): PokedexRepository {
            if(!Companion::repository.isInitialized){
                repository = PokedexRepository(ctx)
            }

            return repository

        }

    }

    fun createTable () {


//        dbWriter.execSQL(Constants.CREATE_TABLE + " " + Constants.SPRITE_TABLE + " ("
//                + "id integer primary key,"
//                + SpriteConstants.BACK_DEFAULT + " TEXT,"
//                + SpriteConstants.BACK_FEMALE + " TEXT,"
//                + SpriteConstants.BACK_SHINY + " TEXT,"
//                + SpriteConstants.BACK_SHINY_FEMALE + " TEXT,"
//                + SpriteConstants.FRONT_DEFAULT + " TEXT,"
//                + SpriteConstants.FRONT_FEMALE + " TEXT,"
//                + SpriteConstants.FRONT_SHINY + " TEXT,"
//                + SpriteConstants.FRONT_SHINY_FEMALE + " TEXT)")
//

        dbWriter.execSQL(Constants.CREATE_TABLE + " " + Constants.POKEMON_TABLE
                + " (id Integer primary key, name TEXT)")

    }

    fun newTable() {



    }


    fun insertInto(pm: PokemonModel) {

        try {

            val contentValuesPokemon = ContentValues()
            contentValuesPokemon.put("id", pm.id)
            contentValuesPokemon.put("name", pm.name)

            dbWriter.insert(Constants.POKEMON_TABLE, null, contentValuesPokemon)

            val contentValuesSprite = ContentValues()

            contentValuesSprite.put("id", pm.id)
            contentValuesSprite.put(SpriteConstants.BACK_DEFAULT, pm.sprites.back_default)
            contentValuesSprite.put(SpriteConstants.BACK_FEMALE, pm.sprites.back_female)
            contentValuesSprite.put(SpriteConstants.BACK_SHINY, pm.sprites.back_shiny)
            contentValuesSprite.put(SpriteConstants.BACK_SHINY_FEMALE, pm.sprites.back_shiny_female)
            contentValuesSprite.put(SpriteConstants.FRONT_DEFAULT, pm.sprites.front_default)
            contentValuesSprite.put(SpriteConstants.FRONT_FEMALE, pm.sprites.front_female)
            contentValuesSprite.put(SpriteConstants.FRONT_SHINY, pm.sprites.front_shiny)
            contentValuesSprite.put(
                SpriteConstants.FRONT_SHINY_FEMALE,
                pm.sprites.front_shiny_female
            )
            contentValuesSprite.put(SpriteConstants.OFFICIAL_ARTWORK_COLUMN,pm.sprites.other.officialArtwork.front_default)

            dbWriter.insert(Constants.SPRITE_TABLE, null, contentValuesSprite)

            val contentValuesType = ContentValues()
            contentValuesType.put("id", pm.id)
            contentValuesType.put("firstType", pm.types[0].type.name)

            if (pm.types.size > 1 && pm.types[1].type.name != "") {
                contentValuesType.put("secondType", pm.types[1].type.name)

            } else {

                contentValuesType.put("secondType", "")

            }

            dbWriter.insert(Constants.TYPE_TABLE, null, contentValuesType)

        } catch (e: SQLiteException) {

            e.printStackTrace()
        }

    }

    fun select(
        table: String, columns: Array<String>?, selection: String?, selectionArgs: Array<String>?,
        groupBy: String?, having: String?, orderBy: String?
    ): Cursor {

        return dbReadable.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)

    }

    fun execQueryDB(query: String){

        dbWriter.execSQL(query)

    }

    fun hasTable(tableName: String): Boolean {

        return try {

            dbReadable.query(tableName, null, null, null, null, null, null)
            true

        } catch(e: SQLiteException) {
            false

        }


    }

    fun dropTable() {

        try {
            dbWriter.execSQL("DROP TABLE Pokemon")

        }
        catch (e: SQLiteException) {

            e.printStackTrace()
        }

    }

}