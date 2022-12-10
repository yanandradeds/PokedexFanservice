package com.example.pokedexfanservice.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokedexfanservice.appconstants.DatabaseConstants
import com.example.pokedexfanservice.repository.model.*

@Database(entities = [
    DatabaseBaseStatsPokemonModel::class,
    DatabaseCompatibleMovesModel::class,
    DatabaseMoveModel::class,
    DatabasePokemonModel::class,
    DatabaseTypeModel::class ],
    version = DatabaseConstants.VERSION)
abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun dataAccessObject() : ApplicationDAO

    companion object{
        private lateinit var uniqueInstance: ApplicationDatabase

        fun dataAccessObject(context: Context): ApplicationDAO {
            if(!Companion::uniqueInstance.isInitialized) {
                synchronized(ApplicationDatabase::class) {
                    uniqueInstance = Room.databaseBuilder(context, ApplicationDatabase::class.java,
                        DatabaseConstants.DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return  uniqueInstance.dataAccessObject()
        }

    }

}




