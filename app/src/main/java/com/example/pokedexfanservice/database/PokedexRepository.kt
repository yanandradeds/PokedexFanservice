package com.example.pokedexfanservice.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteException
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import androidx.core.database.getStringOrNull
import androidx.core.os.HandlerCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.pokedexfanservice.constants.DatabaseConstants
import com.example.pokedexfanservice.constants.SpriteConstants
import com.example.pokedexfanservice.model.PokemonModel
import java.io.ByteArrayOutputStream
import java.lang.Exception

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

    fun teste (ctx: Context) {


    }

    fun select(
        table: String, columns: Array<String>?, selection: String?, selectionArgs: Array<String>?,
        groupBy: String?, having: String?, orderBy: String?
    ): Cursor {

        return dbReadable.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)

    }


}