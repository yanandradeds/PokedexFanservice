package com.example.pokedexfanservice.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class PokedexDatabase(ctx: Context) : SQLiteOpenHelper(ctx, Constants.DATABASE_NAME, null, Constants.VERSION) {


    override fun onCreate(db: SQLiteDatabase) {

        //db.execSQL("CREATE TABLE Pokemon (id integer primary key, name text, front text, back text, fstType text, sndType text)")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {



    }




}