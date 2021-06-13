package com.insanie.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_move_with_data.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_move_activity.setOnClickListener(this)
        btn_move_activity_data.setOnClickListener(this)
        btn_move_activity_object.setOnClickListener(this)
        btn_dial_number.setOnClickListener(this)
        btn_move_for_result.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity,MoveActivityApp::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data ->{
                val moveWithDataIntent = Intent(this@MainActivity,MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME,"Fathie_Insanie")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE,21)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_move_activity_object -> {
                val person = Person(
                    "Fathie_Insani",
                    20,
                    "Insani@gmail.com",
                    "Cirebon"
                )
                val moveWithObjectIntent =Intent(this@MainActivity,MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON,person)
                startActivity(moveWithObjectIntent)
            }
            R.id.btn_dial_number -> {
                val dialPhoneNumber = Intent(Intent.ACTION_DIAL,Uri.parse("tel:089525405180"))
                startActivity(dialPhoneNumber)
            }
            R.id.btn_move_for_result ->{
                val moveForResultIntent = Intent(this@MainActivity,MoveForResultActivity::class.java)
                startActivityForResult(moveForResultIntent, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                val selecedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE,0)
                tv_result.text = "Hasil : $selecedValue"
            }
        }
    }

    companion object{
        private const val REQUEST_CODE = 100
    }
}