package com.cesarschool.helloword

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private val listEstados = mutableListOf(
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

            val builder = AlertDialog.Builder(this)
            builder.setPositiveButton("Sim",
                    DialogInterface.OnClickListener { dialog, id ->
                        listEstados.removeAt(position)
                        adapter.notifyDataSetChanged()
                    })
            builder.setNegativeButton("Não", null)
            builder.setTitle("REMOVER")
            builder.setMessage("Você deseja remover o estado: $nome?")
            builder.show()
        }
    }
}