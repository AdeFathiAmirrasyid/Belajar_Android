package com.fathi.wisatacirebon

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplasScreen : AppCompatActivity() {

    lateinit var  handler : Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splas_screen)

        requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        handler = Handler()

        handler.postDelayed( {
            intent = Intent(this@SplasScreen, MainActivity::class.java)
            startActivity(intent)
            this@SplasScreen.finish()
        }, 1000)
    }

}
