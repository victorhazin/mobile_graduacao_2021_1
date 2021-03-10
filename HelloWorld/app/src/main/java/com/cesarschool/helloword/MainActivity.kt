package com.cesarschool.helloword

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val MAIN_ACTIVITY_EXTRA_NAME_ID = "MAIN_ACTIVITY_EXTRA_NAME_ID"
        const val MAIN_ACTIVITY_EXTRA_CAR_ID = "MAIN_ACTIVITY_EXTRA_CAR_ID"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonMainActivity.setOnClickListener{
            val name = editTextTextPersonName.text.toString()
            if(isNameValid(name)){
                val novaActivity = Intent(this, NovaActivity::class.java)
                novaActivity.putExtra(Companion.MAIN_ACTIVITY_EXTRA_NAME_ID, name)

                val myCar = Car("Gol", "Teste", 2021)
                novaActivity.putExtra(MAIN_ACTIVITY_EXTRA_CAR_ID, myCar)
                startActivity(novaActivity)
            }else{
                Toast.makeText(this, "Please fill you name", Toast.LENGTH_LONG)
            }
        }

    }

    private fun isNameValid(name: String): Boolean = !name.isNullOrEmpty()
}