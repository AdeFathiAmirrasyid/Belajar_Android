package com.insanie.apprecyclerview

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        handler = Handler()
        handler.postDelayed({
            intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
            this@SplashScreen.finish()
        }, 1500)
    }
}