package com.game.informationapp2

import android.content.AsyncQueryHandler
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainHandler: Handler
    var counter = 0
    private val tiktik = object : Runnable{
        override fun run() {
            counter++
            Log.i("lifecycle",counter.toString())
            mainHandler.postDelayed(this,1000)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("lifecycle","OnCreate....")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit_btn.setOnClickListener(){
            val intent = Intent (this,ResultActivity::class.java)
            intent.putExtra("Name",nameText.text.toString())
            intent.putExtra("Age",numText.text.toString())
            startActivity(intent)
        }
        mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post(tiktik)
    }

    override fun onStart() {
        super.onStart()
        Log.i("lifecycle","OnStart....")
    }
    override fun onResume() {
        super.onResume()
        Log.i("lifecycle","OnResume")
        mainHandler.post(tiktik)
    }

    override fun onPause() {
        super.onPause()
        Log.i("lifecycle","OnPause")
        mainHandler.removeCallbacks(tiktik)
    }

    override fun onStop() {
        super.onStop()
        Log.i("lifecycle","OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("lifecycle","OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("lifecycle","OnDestr0y")
    }
}