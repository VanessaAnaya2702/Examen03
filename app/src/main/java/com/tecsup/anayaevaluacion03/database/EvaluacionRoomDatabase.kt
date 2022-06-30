package com.tecsup.anayaevaluacion03.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tecsup.anayaevaluacion03.model.LibroDao
import com.tecsup.anayaevaluacion03.model.dao.Libro


@Database(entities = [Libro::class], version = 1)
abstract class EvaluacionRoomDatabase: RoomDatabase() {
    abstract fun libroDao(): LibroDao

    companion object{
        private const val DATABASE_NAME = "evaluacion_database"
        @Volatile
        private var INSTANCE: EvaluacionRoomDatabase? = null

        fun getInstance(context: Context):EvaluacionRoomDatabase?{
            INSTANCE?: synchronized(this){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    EvaluacionRoomDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }

}