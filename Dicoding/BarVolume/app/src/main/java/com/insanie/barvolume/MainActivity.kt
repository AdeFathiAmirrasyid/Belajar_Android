package com.insanie.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_inpput.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val inputLength = panjangEdit.text.toString()
        val inputWidth = lebarEdit.text.toString()
        val inputHeigth = tinggiEdit.text.toString()

        if (panjangEdit.text.toString().isEmpty()) {
            panjangEdit.error = "Field ini tidak boleh kosong"
        }else if (lebarEdit.text.toString().isEmpty()){
            lebarEdit.error = "Field ini tidak boleh kosong"
        }else if (tinggiEdit.text.toString().isEmpty()){
            tinggiEdit.error = "Field ini tidak boleh kosong"
        }
        else {
            val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeigth.toDouble()
            resultText.text = volume.toString()
        }
    }

}