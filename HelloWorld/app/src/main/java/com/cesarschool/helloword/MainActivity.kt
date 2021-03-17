package com.cesarschool.helloword

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.AlarmClock
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val MAIN_ACTIVITY_EXTRA_NAME_ID = "MAIN_ACTIVITY_EXTRA_NAME_ID"
        const val MAIN_ACTIVITY_EXTRA_CAR_ID = "MAIN_ACTIVITY_EXTRA_CAR_ID"
        const val MAIN_ACTIVITY_EXTRA_NUMBER_1 = "MAIN_ACTIVITY_EXTRA_NUMBER_1"
        const val MAIN_ACTIVITY_EXTRA_NUMBER_2 = "MAIN_ACTIVITY_EXTRA_NUMBER_2"
        const val MAIN_ACTIVITY_EXTRA_SUM_ID = "MAIN_ACTIVITY_EXTRA_SUM"
        const val MAIN_ACTIVITY_SUM_RESULT_CODE = 1
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
        buttonOk.setOnClickListener{
            val valor1 = editTextNumber1.text.toString()
            val valor2 = editTextNumber2.text.toString()
            val terceiraActivityIntent = Intent(this, TerceiraActivity::class.java)
            terceiraActivityIntent.putExtra(MAIN_ACTIVITY_EXTRA_NUMBER_1, valor1)
            terceiraActivityIntent.putExtra(MAIN_ACTIVITY_EXTRA_NUMBER_2, valor2)

            startActivityForResult(terceiraActivityIntent, MAIN_ACTIVITY_SUM_RESULT_CODE)
        }

        buttonCancel.setOnClickListener{
            val message = editTextTextPersonName.text.toString()
            val hour = editTextNumber1.text.toString()
            val minute = editTextNumber2.text.toString()
            createAlarm(hour.toInt(), minute.toInt(), message)
        }

    }

    private fun createAlarm(hours: Int , min: Int , message: String){

        val permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.SET_ALARM)
        if(permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.d("Notification", "Permission not granted earlier, permission: $permissionCheck")
            ActivityCompat.requestPermissions(this, arrayOf<String>(android.Manifest.permission.SET_ALARM),1)
        } else {
            Log.d("Notification", "Permission was already granted")
        }

        val intentAlarm = Intent(AlarmClock.ACTION_SET_ALARM)
        intentAlarm.putExtra(AlarmClock.EXTRA_MESSAGE, message)
        intentAlarm.putExtra(AlarmClock.EXTRA_HOUR, hours)
        intentAlarm.putExtra(AlarmClock.EXTRA_MESSAGE, min)

        if(intentAlarm.resolveActivity(packageManager) != null){
            startActivity(intentAlarm)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            if(MAIN_ACTIVITY_SUM_RESULT_CODE == requestCode){
                val result = data?.getStringExtra(MAIN_ACTIVITY_EXTRA_SUM_ID)
                Toast.makeText(this, "SOMA: $result", Toast.LENGTH_LONG)
            }
        }else if (resultCode == Activity.RESULT_CANCELED){
        }
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }


    private fun isNameValid(name: String): Boolean = !name.isNullOrEmpty()
}