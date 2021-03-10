package com.cesarschool.helloword

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nova.*


class NovaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova)

        val name = intent.getStringExtra(MainActivity.MAIN_ACTIVITY_EXTRA_NAME_ID)

        val car = intent.getParcelableExtra<Car>(MainActivity.MAIN_ACTIVITY_EXTRA_CAR_ID)
        if(car != null) {
            textView.text = getString(R.string.second_activity_message, name, car.nome )
        }else{
            textView.text = name
        }
    }
}