package com.cesarschool.helloword

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonMainActivity.setOnClickListener{
            val novaActivity = Intent(this, NovaActivity::class.java)
            startActivity(novaActivity)
        }

    }
}