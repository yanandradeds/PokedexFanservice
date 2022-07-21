package com.example.pokedexfanservice.view

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.AsyncTask.execute
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.ByteBufferFileLoader
import com.example.pokedexfanservice.adapter.PokedexAdapter
import com.example.pokedexfanservice.database.SpriteConstants
import com.example.pokedexfanservice.databinding.ActivityMainBinding
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.viewmodel.PokemonViewModel
import com.squareup.picasso.Picasso
import java.io.BufferedInputStream
import java.io.File
import java.io.InputStream
import java.lang.Exception
import java.net.URI
import java.net.URL
import java.sql.Blob
import java.sql.Connection


class MainActivityView : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PokemonViewModel
    private val adapterClass = PokedexAdapter()
    private val customLayoutManager = GridLayoutManager(this,5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)
        supportActionBar?.hide()

        //Parametros padrão da RecycleView
        binding.recyclerUnique.layoutManager = customLayoutManager
        binding.recyclerUnique.adapter = adapterClass

        setPrincipalImageFirstTime()


        // Pega dados na PokeAPI e salva no DB
        // viewModel.getDataInAPI()

        adapterClass.updateList(viewModel.getAll())



        val listener = object : OnPokedexListener {

            override fun onClick(pkm: PokemonModel) {

                val name = pkm.name.replaceFirstChar { it.uppercase() }
                val type = pkm.types[0].type.name.replaceFirstChar { it.uppercase() }
                val url = pkm.sprites.other.officialArtwork.front_default

                binding.textNameAndId.text = "${pkm.id} $name"
                binding.textPokemonDesc.text = name
                binding.textPokemonType.text = type
                Glide.with(binding.imagePrincipalSprite).load(url).into(binding.imagePrincipalSprite)

            }
        }

        adapterClass.attachListener(listener)

    }

    private fun setPrincipalImageFirstTime() {

        val imageUrl = viewModel.getSpritePokemon(1,SpriteConstants.OFFICIAL_ARTWORK_COLUMN)
        Glide.with(this).load(imageUrl).into(binding.imagePrincipalSprite)
        binding.textNameAndId.text = "1 Bulbassauro"

    }


}