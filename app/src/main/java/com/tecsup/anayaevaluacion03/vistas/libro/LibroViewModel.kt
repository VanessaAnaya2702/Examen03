package com.tecsup.anayaevaluacion03.vistas.libro

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.tecsup.anayaevaluacion03.model.dao.Libro
import kotlinx.coroutines.launch

class LibroViewModel (application: Application): AndroidViewModel(application) {
    private val repository = LibroRepository(application)
    // Listado
    val books = repository.getBooks()

    // Registro
    fun saveBook(libro: Libro){
        viewModelScope.launch{
            repository.insertBookWithCoroutines(libro)
        }
    }

    // Actualizar
    fun updateBook(libro: Libro){
        viewModelScope.launch {
            repository.updateBookWithCoroutines(libro)
        }
    }
}