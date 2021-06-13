package com.insanie.myintentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonMoveActivity.setOnClickListener(this)
        buttonWithDataActivity.setOnClickListener(this)
        buttonDialPhone.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonMoveActivity -> {
                val intent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(intent)
            }

            R.id.buttonWithDataActivity -> {
                val moveWithDataActivityIntent =
                    Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataActivityIntent.putExtra(
                    MoveWithDataActivity.EXTRA_NAME,
                    "Fathie_Insanie"
                )
                moveWithDataActivityIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 90)
                startActivity(moveWithDataActivityIntent)
            }
            R.id.buttonDialPhone -> {
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: 089525405180"))
                startActivity(dialPhoneIntent)
            }
        }
    }

 

}