package com.tecsup.anayaevaluacion03.vistas.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.tecsup.anayaevaluacion03.R
import com.tecsup.anayaevaluacion03.vistas.libro.LibroFragment

class HomeActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val actionBar = supportActionBar
        actionBar?.hide()

        openFragment(LibroFragment.newInstance())
    }
    private fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framelayoutContent,fragment)
        transaction.commit()

    }
}