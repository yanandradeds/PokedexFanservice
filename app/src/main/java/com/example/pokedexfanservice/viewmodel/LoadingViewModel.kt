package com.example.pokedexfanservice.viewmodel

import android.app.Application
import android.graphics.Bitmap
import android.text.BoringLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexfanservice.database.PokedexDatabase
import com.example.pokedexfanservice.database.tables.MovesTableModel
import com.example.pokedexfanservice.model.MovesModel
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.database.tables.PokemonTableModel
import com.example.pokedexfanservice.database.tables.SpritesTableModel
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

class LoadingViewModel(application: Application) : AndroidViewModel(application) {

    private val database = PokedexDatabase.getDataBase(application).getDAOInterface()
    private val app = application

    suspend fun getDataFromApi() {

        try {

            val retrofitBuild = RetrofitConnection.singleton().create(Service::class.java)
            val callbackForMoves = object : Callback<MovesModel> {
                override fun onResponse(
                    call: Call<MovesModel>,
                    response: Response<MovesModel>
                ) {
                    val body = response.body()!!

                    viewModelScope.launch(Dispatchers.IO) {

                        val move = MovesTableModel().apply {
                            id = body.id
                            name = body.name
                            pp = body.pp
                            power = body.pp
                            accuracy = body.accuracy
                            type = body.type.typeName
                        }

                        database.insertMove(move)
                    }
                }
                override fun onFailure(call: Call<MovesModel>, t: Throwable) {
                    throw t
                }
            }

            val callbackForPokemons = object : Callback<PokemonModel> {
                override fun onResponse(
                    call: Call<PokemonModel>,
                    response: Response<PokemonModel>
                ) {
                    val body = response.body()!!

                    viewModelScope.launch(Dispatchers.IO) {

                        val pokemon = PokemonTableModel().apply {
                            id = body.id
                            name = body.name
                            firstType = body.typeModel[0].typeName.name

                            if (body.typeModel.size == 2) {
                                secondType = body.typeModel[1].typeName.name
                            }
                        }

                        database.insert(pokemon)

                        val outputFront = ByteArrayOutputStream()
                        val outputArtwork = ByteArrayOutputStream()

                        val frontSprite: Bitmap =
                            Picasso.get().load(body.sprites.front_default).get()
                        val officialSprite: Bitmap = Picasso.get()
                            .load(body.sprites.other.official_artwork.front_default_artwork)
                            .get()

                        frontSprite.compress(Bitmap.CompressFormat.PNG, 50, outputFront)
                        officialSprite.compress(Bitmap.CompressFormat.PNG, 100, outputArtwork)

                        val sprite = SpritesTableModel().apply {
                            id = body.id
                            front_default = outputFront.toByteArray()
                            official_artwork = outputArtwork.toByteArray()
                        }

                        database.insert(sprite)

                    }
                }

                override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
                    throw t
                }
            }



            for (n in 1..151) {

                retrofitBuild.getData(n).enqueue(callbackForPokemons)

            }
            for (n in 1..165) {
                retrofitBuild.getMoves(n).enqueue(callbackForMoves)
            }

        } catch (e: Exception) {
            Toast.makeText(app, "Getting data failed", Toast.LENGTH_SHORT).show()
            e.printStackTrace()

        }

    }

}
