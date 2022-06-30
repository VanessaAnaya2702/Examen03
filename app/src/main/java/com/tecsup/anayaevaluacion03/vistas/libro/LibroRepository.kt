package com.tecsup.anayaevaluacion03.vistas.libro

import android.app.Application
import androidx.lifecycle.LiveData
import com.tecsup.anayaevaluacion03.database.EvaluacionRoomDatabase
import com.tecsup.anayaevaluacion03.model.LibroDao
import com.tecsup.anayaevaluacion03.model.dao.Libro
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class LibroRepository (application: Application){
    private val bookDao: LibroDao? = EvaluacionRoomDatabase.getInstance(application)?.libroDao()

    //LiveData:
    fun getBooks(): LiveData<List<Libro>> {
        return bookDao?.getListBook()!!
    }

    //Registro
    suspend fun insertBookWithCoroutines(book: Libro){
        processInsertBook(book)
    }
    private suspend fun processInsertBook(book: Libro){
        withContext(Dispatchers.Default){
            bookDao?.insert(book)
        }
    }

    // Actualizar
    suspend fun updateBookWithCoroutines(libro: Libro) {
        processUpdateBook(libro)
    }
    private suspend fun processUpdateBook(libro: Libro) {
        withContext(Dispatchers.Default) {
            bookDao?.update(libro)
        }
    }

}