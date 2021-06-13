package com.insanie.testingsp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //sharef prefence
        sharedPref = getPreferences(Context.MODE_PRIVATE)

        val mainText = findViewById<TextView>(R.id.mainText)


        //load main text
        mainText.text = load("app_title")

        button.setOnClickListener(){
            val text = editText.text.toString()
            mainText.text = text
            save(text)
        }
    }
    private fun save(text : String){
        with(sharedPref.edit()){
            putString("app_title",text)
            commit()
        }
    }
    private fun load(key : String) : String{
       return sharedPref.getString(key,"Hello Word!").toString()
    }
}