package com.example.pokedexfanservice.viewmodel

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.database.PokedexDatabase
import com.example.pokedexfanservice.database.tables.PokemonTableModel
import com.example.pokedexfanservice.database.tables.SpritesTableModel
import kotlinx.coroutines.launch
import javax.inject.Singleton

class PokedexFragmentViewModel(context: Context): ViewModel() {

    private val database = PokedexDatabase.getDataBase(context).getDAOInterface()
    private lateinit var listSprite: List<SpritesTableModel>
    private lateinit var listPokemon: List<PokemonTableModel>
    private lateinit var pokedexAdapter: RecyclerView.Adapter<PokedexViewHolder>

    suspend fun createAdapter(): RecyclerView.Adapter<PokedexViewHolder> {

        listSprite = database.getSpriteAll()
        listPokemon = database.getAll()

        @Singleton
        pokedexAdapter = object : RecyclerView.Adapter<PokedexViewHolder>() {

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexViewHolder {

                val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_pokedex_fragment,parent,false)
                val imageView = view.findViewById<ImageView>(R.id.image_pokemon_sprite)
                imageView.minimumHeight = imageView.width

                return PokedexViewHolder(view)
            }

            override fun onBindViewHolder(itemBinding: PokedexViewHolder, pos: Int) {

                itemBinding.onBind(listSprite[pos],listPokemon[pos])

            }

            override fun getItemCount(): Int {
                return listSprite.size
            }

        }

        return pokedexAdapter
    }

    fun getLiveData(): LiveData<PokemonTableModel>{
        return database.livedataDB()
    }

}

class PokedexViewHolder(val view : View): RecyclerView.ViewHolder(view){

    fun onBind(sprite: SpritesTableModel,pokemon: PokemonTableModel) {

        val imageView = view.findViewById<ImageView>(R.id.image_pokemon_sprite)
        val textView = view.findViewById<TextView>(R.id.text_row_pokemon_id)
        val bitmap = BitmapFactory.decodeByteArray(
            sprite.front_default,0,sprite.front_default.size
        )

        imageView.setImageBitmap(bitmap)

        textView.text =
            if(sprite.id < 10) "00${sprite.id} ${pokemon.name.replaceFirstChar{it.uppercase()} }"
            else if (sprite.id < 100) "0${sprite.id} ${pokemon.name.replaceFirstChar{it.uppercase()} }"
            else "${sprite.id} ${pokemon.name.replaceFirstChar{it.uppercase()} }"

    }
}
