package com.example.pokedexfanservice.viewmodel

import android.app.Application
import android.graphics.Bitmap
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedexfanservice.database.PokedexDatabase
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.model.PokemonTableModel
import com.example.pokedexfanservice.model.SpritesTableModel
import com.example.pokedexfanservice.retrofitholder.RetrofitConnection
import com.example.pokedexfanservice.retrofitholder.Service
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import kotlin.Exception
import kotlin.properties.Delegates

class LoadingViewModel(application: Application) : AndroidViewModel(application) {

    private val database = PokedexDatabase.getDataBase(application).getDAOInterface()
    private val app = application

    fun getDataFromApi(): Boolean {

        return try {
            val retrofitBuild = RetrofitConnection.singleton().create(Service::class.java)

            viewModelScope.launch {
                if (database.getSprite(151) == null) {
                    for (n in 1..151) {
                        retrofitBuild.getData(n).enqueue(CallbackHolder())
                    }
                }
            }

            true
        } catch (e: Exception) {
            Toast.makeText(app, "Getting data failed", Toast.LENGTH_SHORT).show()
            false
        }

    }


    private inner class CallbackHolder() : Callback<PokemonModel> {

        override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {

            val body = response.body()!!

            viewModelScope.launch {

                database.insert(PokemonTableModel().apply {
                    id = body.id
                    name = body.name
                    firstType = body.typeModel[0].typeName.name
                    if (body.typeModel.size == 2) secondType = body.typeModel[1].typeName.name
                })

                withContext(Dispatchers.IO) {
                    val outputFront = ByteArrayOutputStream()
                    val outputArtwork = ByteArrayOutputStream()

                    val frontSprite: Bitmap =
                        Picasso.get().load(body.sprites.front_default).get()
                    val officialSprite: Bitmap = Picasso.get()
                        .load(body.sprites.other.official_artwork.front_default_artwork).get()

                    frontSprite.compress(Bitmap.CompressFormat.PNG, 100, outputFront)
                    officialSprite.compress(Bitmap.CompressFormat.PNG, 100, outputArtwork)

                    database.insert(SpritesTableModel().apply {
                        id = body.id
                        front_default = outputFront.toByteArray()
                        official_artwork = outputArtwork.toByteArray()

                    })
                }
            }


        }

        override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
            throw t
        }

    }

}
