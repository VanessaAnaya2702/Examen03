package com.tecsup.anayaevaluacion03.vistas.libro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.anayaevaluacion03.model.dao.Libro


class LibroAdapter(val mItemClickListener: ItemClickListener): RecyclerView.Adapter<LibroViewHolder>() {
    private var bookList = emptyList<Libro>()

    fun setBooks(libros: List<Libro>) {
        this.bookList = libros
        this.notifyDataSetChanged()
    }
    override fun getItemCount(): Int = bookList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LibroViewHolder(inflater, parent)
    }
    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val book: Libro =  bookList[position]
        holder.bind(book)
        holder.itemView.setOnClickListener{
            mItemClickListener.onItemClick(book)
        }
    }
    interface ItemClickListener{
        fun onItemClick(libro: Libro)
    }
}