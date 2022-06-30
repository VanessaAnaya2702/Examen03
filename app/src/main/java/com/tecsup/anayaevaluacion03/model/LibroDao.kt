package com.tecsup.anayaevaluacion03.model

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tecsup.anayaevaluacion03.model.dao.Libro

@Dao
interface LibroDao {
    @Insert
    fun insert(libro: Libro)
    @Update
    fun update(libro: Libro)
    @Delete
    fun delete(libro: Libro)

    @Query("select * from book_table order by nombre_book asc")
    fun getListBook(): LiveData<List<Libro>>

    @Query("update book_table set nombre_book=:nombre,autor_book=:autor where book_id=:id")
    fun update(nombre:String, autor:String, id: Int)
}