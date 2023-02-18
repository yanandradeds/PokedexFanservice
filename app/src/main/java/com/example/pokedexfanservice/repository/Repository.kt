package com.example.pokedexfanservice.repository

import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexfanservice.model.MovesModel
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.repository.model.*
import com.example.pokedexfanservice.retrofitholder.PokeApiEndpoints
import com.example.pokedexfanservice.retrofitholder.RetrofitClient
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream

class Repository private constructor(context: Context){

    private val database = ApplicationDatabase.dataAccessObject(context)
    private val retrofit = RetrofitClient.singleton().create(PokeApiEndpoints::class.java)

    companion object {
        private lateinit var repo: Repository

        fun instance(_context: Context): Repository{
            if(!(Companion::repo.isInitialized)){
                repo = Repository(_context)
            }
            return repo
        }
    }

    fun getPokemonsLiveData(): LiveData<List<DatabasePokemonModel>> {
        return database.getPokemons()
    }

    suspend fun getPokemonList(): List<DatabasePokemonModel> {
        return withContext(Dispatchers.IO) {
            database.getPokemonsList()
        }
    }

    fun requestingData(viewModel: ViewModel) {
        pokemonDataHolder(viewModel)
        moveDataHolder(viewModel)
    }

    suspend fun listPokemonFilteredByType(type: String): List<DatabasePokemonModel>{
        return withContext(Dispatchers.IO) {
            val listTypeModel = database.filterListByType(type)
            val listPokemonModel = arrayListOf<DatabasePokemonModel>()

            listTypeModel.forEach {
                val pokemon = database.getPokemonById(it.pokemonID)
                listPokemonModel.add(pokemon)
            }

            listPokemonModel
        }
    }

    private fun pokemonDataHolder(viewModel: ViewModel) {
        viewModel.viewModelScope.launch(Dispatchers.IO) {

            val pokemonContentExist: Boolean = database.lastPokemon() == 151

            if (!pokemonContentExist) {
                for (i in 1..151) {
                    retrofit.getPokemon(i).enqueue(object : Callback<PokemonModel> {

                        override fun onResponse(
                            call: Call<PokemonModel>, response: Response<PokemonModel>
                        ) {
                            pokemonModelDataHolder(viewModel, response)
                            compatibleMovesModelDataHolder(viewModel, response)
                            typeModelDataHolder(viewModel, response)
                            baseStatsModelDataHolder(viewModel, response)
                        }

                        override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
                            throw t
                        }

                    })
                }
            }

        }
    }

    private fun moveDataHolder(viewModel: ViewModel) {
        viewModel.viewModelScope.launch(Dispatchers.IO) {

            val moveContentExist: Boolean = database.lastMove() == 165

            if (!moveContentExist) {

                for (moveID in 1..165){
                    retrofit.getMove(moveID).enqueue(object : Callback<MovesModel>{
                        override fun onResponse(call: Call<MovesModel>, response: Response<MovesModel>) {
                            moveModelDataHolder(viewModel, response)
                        }

                        override fun onFailure(call: Call<MovesModel>, t: Throwable) {
                            throw t
                        }
                    })
                }

            }
        }
    }

    private fun pokemonModelDataHolder(viewModel: ViewModel, response: Response<PokemonModel>) {
        val body = response.body()!!

        viewModel.viewModelScope.launch(Dispatchers.IO) {
            val bitmap= Picasso.get().load(body.spritesHeadTree.spritesList.spriteOfficial.urlSprite).get()
            val output = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG,80,output)

            val pokemon = DatabasePokemonModel(
                body.id,
                body.name,
                output.toByteArray()
            )

            database.insert(pokemon)
        }
    }

    private fun moveModelDataHolder(viewModel: ViewModel, response: Response<MovesModel>) {
        val body = response.body()!!

        viewModel.viewModelScope.launch {
            database.insert(
                DatabaseMoveModel(
                    body.id,
                    body.name,
                    body.power,
                    body.pp,
                    body.accuracy,
                    body.type.typeName
                )
            )
        }
    }

    private fun typeModelDataHolder(viewModel: ViewModel, response: Response<PokemonModel>) {
        val body = response.body()!!

        viewModel.viewModelScope.launch(Dispatchers.IO){
            val type = DatabaseTypeModel(
                body.id,
                body.typeModel[0].typeName.name,

                if(body.typeModel.size == 2) {
                    body.typeModel[1].typeName.name
                } else {
                    ""
                }

            )

            database.insert(type)
        }
    }

    private fun baseStatsModelDataHolder(viewModel: ViewModel, response: Response<PokemonModel>) {
        val body = response.body()!!

        val baseStats = DatabaseBaseStatsPokemonModel(
            body.id,
            body.stats[0].valueStat,
            body.stats[1].valueStat,
            body.stats[2].valueStat,
            body.stats[3].valueStat,
            body.stats[4].valueStat,
            body.stats[5].valueStat
        )

        viewModel.viewModelScope.launch(Dispatchers.IO){
            database.insert(baseStats)
        }
    }

    private fun compatibleMovesModelDataHolder(viewModel: ViewModel, response: Response<PokemonModel>) {
        val body = response.body()!!
        var mMoveID = 0

        body.moves.forEach {
            val movePathID = it.move.url.split("/").toMutableList()
            movePathID.removeLast()
            mMoveID = movePathID.last().toInt()
        }

        viewModel.viewModelScope.launch(Dispatchers.IO){
            database.insert(
                DatabaseCompatibleMovesModel().apply {
                    pokemonID = body.id
                    moveID = mMoveID
                }
            )
        }
    }

}