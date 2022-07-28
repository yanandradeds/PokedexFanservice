package com.example.pokedexfanservice.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.pokedexfanservice.constants.DatabaseConstants

class PokedexDatabase(ctx: Context) : SQLiteOpenHelper(ctx, DatabaseConstants.DATABASE_NAME, null, DatabaseConstants.VERSION) {


    override fun onCreate(db: SQLiteDatabase) {

        //db.execSQL("CREATE TABLE Pokemon (id integer primary key, name text, front text, back text, fstType text, sndType text)")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {



    }




}