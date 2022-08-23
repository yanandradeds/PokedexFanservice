package com.example.pokedexfanservice.viewmodel

import android.app.Application
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Looper

import androidx.lifecycle.AndroidViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.pokedexfanservice.database.PokedexDatabase
import com.example.pokedexfanservice.model.*
import com.example.pokedexfanservice.model.tablemodel.PokemonTableModel
import com.example.pokedexfanservice.retrofitholder.RetrofitConnection
import com.example.pokedexfanservice.retrofitholder.Service
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.lang.Exception
import java.util.logging.Handler


class PokemonViewModel (application: Application)  : AndroidViewModel(application){

    private val database = PokedexDatabase.getDataBase(application).getDAOInterface()

    fun getAll(): List<PokemonTableModel> {
        return database.getAll()
    }

}
