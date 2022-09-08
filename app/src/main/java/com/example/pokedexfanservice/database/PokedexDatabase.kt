package com.example.pokedexfanservice.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokedexfanservice.constants.DatabaseConstants
import com.example.pokedexfanservice.model.PokemonTableModel
import com.example.pokedexfanservice.model.SpritesTableModel

@Database(entities = [PokemonTableModel::class, SpritesTableModel::class], version = DatabaseConstants.VERSION)
abstract class PokedexDatabase : RoomDatabase() {

    abstract fun getDAOInterface() : PokedexDAO

    companion object{
        private lateinit var uniqueInstance: PokedexDatabase

        fun getDataBase(context: Context): PokedexDatabase {
            if(!::uniqueInstance.isInitialized) {
                synchronized(PokedexDatabase::class) {
                    uniqueInstance = Room.databaseBuilder(context, PokedexDatabase::class.java,
                        DatabaseConstants.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return  uniqueInstance
        }

    }

}




