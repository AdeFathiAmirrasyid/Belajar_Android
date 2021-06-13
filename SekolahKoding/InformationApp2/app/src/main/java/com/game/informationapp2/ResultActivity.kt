package com.game.informationapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        Log.i("lifecycle","OnCreate")

        val name = intent.getStringExtra("Name")
        val age  = intent.getStringExtra("Age")
        val data = name + " - " + age
        resultText.text = data
        
        button.setOnClickListener(){
            val sendIntent : Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT,data)
                    type = "text/plain"
            }

            startActivity(sendIntent)
        }
        if (savedInstanceState != null ){
            val counter_saved = savedInstanceState.getString("COUNTER_NUMBER")
            counterText.text = counter_saved
            counter = counter_saved!!.toInt()
        }
        counterBtn.setOnClickListener(){
            counter++
            counterText.text = counter.toString()
        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run{
            putString("COUNTER_NUMBER",counter.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        Log.i("lifecycle","OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("lifecycle","OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("lifecycle","OnPause")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("lifecycle","OnDestroy")
    }

}