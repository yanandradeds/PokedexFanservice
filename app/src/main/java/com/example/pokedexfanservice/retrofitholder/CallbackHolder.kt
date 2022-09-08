package com.example.pokedexfanservice.retrofitholder

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.model.PokemonTableModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream

class CallbackHoer(): Callback<PokemonModel> {

    override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {


    }

    override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
        t.printStackTrace()
    }

}