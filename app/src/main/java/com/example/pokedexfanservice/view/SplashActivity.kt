package com.example.pokedexfanservice.view

import android.content.Intent
import android.graphics.Bitmap
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.get
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.example.pokedexfanservice.databinding.ActivitySplashBinding
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.viewmodel.PokemonViewModel
import com.squareup.picasso.Picasso
import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.File
import java.io.InputStream
import java.lang.Exception
import java.net.URI
import java.net.URL

class SplashActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySplashBinding
    private lateinit var pokemonViewModel: PokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pokemonViewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)
        supportActionBar!!.hide()




    }


    class AsyncClass() : AsyncTask<ArrayList<PokemonModel>,Int,ArrayList<Bitmap>>() {

        override fun doInBackground(vararg list: ArrayList<PokemonModel>?): ArrayList<Bitmap> {
            val listBitmap = arrayListOf<Bitmap>()

            for (item in listBitmap) {

                var s = item

            }

            return listBitmap
        }

        override fun onPostExecute(result: ArrayList<Bitmap>?) {

        }
    }

}


