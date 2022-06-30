package com.tecsup.anayaevaluacion03.vistas.libro

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.anayaevaluacion03.R
import com.tecsup.anayaevaluacion03.model.dao.Libro

class LibroViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_libro, parent, false)) {

        private var textTitulo: TextView? = null
        private var textAutor: TextView? = null
        private var textCategoria: TextView? = null
        private var textEditorial: TextView? = null
        private var textDescripcion: TextView? = null

        init {
            textTitulo = itemView.findViewById(R.id.textTitulo)
            textAutor = itemView.findViewById(R.id.textAutor)
            textCategoria = itemView.findViewById(R.id.textCategoria)
            textEditorial = itemView.findViewById(R.id.textEditorial)
            textDescripcion = itemView.findViewById(R.id.textDescripcion)
        }
        fun bind(libro: Libro) {
            textTitulo?.text = libro.titulo
            textAutor?.text = libro.autor
            textCategoria?.text = libro.categoria
            textEditorial?.text = libro.editorial
            textDescripcion?.text = libro.descripcion
        }

}