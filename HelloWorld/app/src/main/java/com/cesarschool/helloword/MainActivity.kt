package com.cesarschool.helloword

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonMainActivity.setOnClickListener{
            mainActivityTextView.setText("O Texto mudou"+ count++)
            Log.d("Button", "cliquei")
        }

    }
}