package com.insanie.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_move_with_data.*

class MoveWithDataActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_AGE = "ALisia"
        const val EXTRA_NAME = "30"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)


        val name = intent.getStringExtra(EXTRA_NAME)
        val age  = intent.getIntExtra(EXTRA_AGE,0)

        val text = "Name : $name, Your Age : $age"
        tv_data_received.text = text
    }
}