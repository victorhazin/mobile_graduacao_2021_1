package com.cesarschool.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private val listEstados = listOf(
            Estado("Pernambuco", 0),
            Estado("Paraíba", 1),
            Estado("São Paulo", 3)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val adapter = EstadoAdapter(this, listEstados)
        estadosListView.adapter = adapter

        estadosListView.setOnItemClickListener {
            parent, view,
            position, id ->

            val(nome, bandeira) = listEstados[position]
            Toast.makeText(this, "click: $$nome $$bandeira", Toast.LENGTH_LONG).show()
        }
    }
}