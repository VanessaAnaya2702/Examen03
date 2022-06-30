package com.tecsup.anayaevaluacion03.vistas.libro

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tecsup.anayaevaluacion03.R
import com.tecsup.anayaevaluacion03.model.dao.Libro
import kotlinx.android.synthetic.main.dialog_book.*
import kotlinx.android.synthetic.main.dialog_book.view.*
import kotlinx.android.synthetic.main.fragment_book.*

class LibroFragment: Fragment(), LibroAdapter.ItemClickListener {

    private lateinit var bookViewModel: LibroViewModel
    lateinit var list: List<Libro>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)
    }
    companion object {
        fun newInstance(): LibroFragment = LibroFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookViewModel = run {
            ViewModelProviders.of(this).get(LibroViewModel::class.java)
        }
        fabRegisterLibro.setOnClickListener {
            registerAndUpdateBook(null, LibroTypeOperation.REGISTER)
        }
        loadData()
    }
    private fun loadData(){
        val adapter = LibroAdapter(this)
        recyclerLibro.adapter = adapter
        recyclerLibro.layoutManager = LinearLayoutManager(activity)

        bookViewModel.books.observe(viewLifecycleOwner){ books ->
            if(books.isNotEmpty()){
                list = books
                books?.let {
                    adapter.setBooks(books)
                }
            }
        }
    }

    private fun registerAndUpdateBook(libro: Libro?, type: LibroTypeOperation) {
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_book, null)
        val titleAlertLibro = if (type == LibroTypeOperation.REGISTER) "Registrar Nuevo Libro" else "Editar Libro"
        val mBuilder = AlertDialog.Builder(context)
            .setView(mDialogView)
            .setTitle(titleAlertLibro)
        val mAlertDialog = mBuilder.show()
        if (type == LibroTypeOperation.UPDATE){
            mDialogView.edtTituloLibro.setText(libro?.titulo)
            mDialogView.edtAutorLibro.setText(libro?.autor)
            mDialogView.edtCategoriaLibro.setText(libro?.categoria)
            mDialogView.edtEditorialLibro.setText(libro?.editorial)
            mDialogView.edtDescripcionLibro.setText(libro?.descripcion)
        }

        mAlertDialog.btnRegisterLibro.setOnClickListener {
            mAlertDialog.dismiss()
            val tituloLibro = mDialogView.edtTituloLibro.text.toString()
            val autorLibro = mDialogView.edtAutorLibro.text.toString()
            val categoriaLibro = mDialogView.edtCategoriaLibro.text.toString()
            val editorialLibro = mDialogView.edtEditorialLibro.text.toString()
            val descripcionLibro = mDialogView.edtDescripcionLibro.text.toString()
            var libro = Libro(tituloLibro, "Autor: " + autorLibro, "Categoria: " + categoriaLibro, "Editorial: " + editorialLibro, descripcionLibro)

            if (type == LibroTypeOperation.REGISTER){
                bookViewModel.saveBook(libro)
            }else{
                if(libro != null){
                    libro.bookID = libro.bookID
                }
                bookViewModel.updateBook(libro)
            }
        }
    }

    override fun onItemClick(libro: Libro) {
        registerAndUpdateBook(libro, LibroTypeOperation.UPDATE)
    }

}