package com.insanie.apprecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    var modelOnePiece : ModelOnePiece? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        modelOnePiece = intent.getParcelableExtra<ModelOnePiece>(MainActivity.KEY_ONEPIECE)
        descriptions(modelOnePiece)

        // source code ini untuk menampilkan tanda panah back di action bar
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }
    }
    // source code ini untuk action back atau tanda panah kembali di action bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
    // source code ini untuk menampilkan description di detail
   fun descriptions(modelOnePiece: ModelOnePiece?){
       modelOnePiece?.apply {
           detailDesc.text = data_desc
           detailImage.setImageResource(data_image)
       }


       supportActionBar?.apply {
           title = modelOnePiece?.data_name
       }
    }
}