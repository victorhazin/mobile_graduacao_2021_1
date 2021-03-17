package com.cesarschool.helloword

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_terceira.*

class TerceiraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terceira)
        val value1 = intent.getStringExtra(MainActivity.MAIN_ACTIVITY_EXTRA_NUMBER_1)
        val value2 = 10//intent.getStringExtra(MainActivity.MAIN_ACTIVITY_EXTRA_NUMBER_2)

        textView2.text = sumValues(value1!!.toInt(), value2!!.toInt()).toString()


        buttonClose.setOnClickListener{
            val returnIntent = Intent()
            val valor = textView2.text.toString();
            returnIntent.putExtra(MainActivity.MAIN_ACTIVITY_EXTRA_SUM_ID, valor)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

    }

    private fun sumValues(value1: Int, value2:Int) = value1 + value2
}

