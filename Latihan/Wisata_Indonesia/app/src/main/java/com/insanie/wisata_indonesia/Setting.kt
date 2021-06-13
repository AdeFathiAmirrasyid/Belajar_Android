package com.insanie.wisata_indonesia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_setting.*

class Setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        supportActionBar?.apply {
            title = "Setting"
            setDisplayHomeAsUpEnabled(true)
        }

        val sharedPref = SharedPref(this)
        settingGrid.isChecked = sharedPref.gridLayout
        settingGrid.setOnCheckedChangeListener{
            buttonView,isChecked ->
                sharedPref.gridLayout = isChecked
        }

        settingLayout.isChecked = sharedPref.descriptions
        settingLayout.setOnCheckedChangeListener{
            buttonVIew,isChecked ->
                sharedPref.descriptions = isChecked
        }

        settingAppName.setText(sharedPref.appName)
        settingAppName.addTextChangedListener{
            sharedPref.appName = it.toString()
        }

        settingColomn.setText(sharedPref.getColomn.toString())
        settingColomn.addTextChangedListener{
            var colomn = if(it.toString().length == 0) 1 else it.toString().toInt()
            colomn = if(colomn > 3){
                3
            }else if(colomn < 1){
                1
            }else{
                colomn
            }

            sharedPref.getColomn = colomn
        }



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}