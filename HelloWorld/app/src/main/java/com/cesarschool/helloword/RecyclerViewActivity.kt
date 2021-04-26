package com.cesarschool.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    private val listEstados = listOf(
        Estado("Pernambuco", 0),
        Estado("Paraíba", 1),
        Estado("São Paulo", 3)
    )

    private val mEstadoRecycleViewAdapter = EstadoRecycleViewAdapter(this, listEstados,
        this::onEstadoClickListener)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        setupRecyclerView()
    }

    private fun onEstadoClickListener(estado: Estado){

    }

    private fun setupRecyclerView(){
        recyclerView.adapter = mEstadoRecycleViewAdapter
//        val layoutManager = LayoutM
//            GridLayoutManager(this, 2)
//        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
//            override fun getSpanSize(position: Int): Int {
//                return if(position==0) 2 else 1
//            }
//        }
//        recyclerView.layoutManager = layoutManager
    }
}

