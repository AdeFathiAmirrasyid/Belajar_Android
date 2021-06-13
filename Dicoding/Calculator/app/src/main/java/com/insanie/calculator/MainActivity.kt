package com.insanie.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            textResult.text = result
        }
    }

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,textResult.text.toString())
    }

    override fun onClick(v: View?) {
       if (v?.id == R.id.buttonCalculate){
           val inputLength = editPanjang.text.toString().trim()
           val inputWidth = editLebar.text.toString().trim()
           val inputTinggi = editTinggi.text.toString().trim()

           var isEmptyFields = false

           when{
               inputLength.isEmpty() ->{
                   isEmptyFields = true
                   editPanjang.error = "Field ini tidak boleh kosong"
               }
               inputWidth.isEmpty()->{
                   isEmptyFields = true
                   editLebar.error = "Field ini tidak boleh kosong"
               }
               inputTinggi.isEmpty()->{
                   isEmptyFields = true
                   editTinggi.error = "Field ini tidak boleh kosong"
               }
           }

           if (!isEmptyFields){
               val volume = inputLength.toDouble() * inputWidth.toDouble() * inputTinggi.toDouble()
               textResult.text = volume.toString()
           }
        }
    }
}
