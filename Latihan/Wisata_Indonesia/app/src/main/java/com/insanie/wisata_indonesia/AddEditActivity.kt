package com.insanie.wisata_indonesia

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_add_edit.*
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_wisata.*

class AddEditActivity : AppCompatActivity() {
    var wisata: Wisata? = null

    companion object{
        const val REQUEST_IMAGE = 400
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit)
        wisata = intent.getParcelableExtra(MainActivity.KEY_WISATA)
        supportActionBar?.apply {
            title = if (wisata == null) "Add Wisata" else "Edit Wisata"
            wisata?.apply {
                subtitle = dataName
            }
            setDisplayHomeAsUpEnabled(true)
        }

        wisata?.apply {
            addEditName.setText(dataName)
            addEditDesc.setText(dataDesc)
            addEditGambar.setText(dataImage)
        }
        buttonBrowse.setOnClickListener{
            val intent = Intent()
            intent.setType("image/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent,"Pilih Gambar"), REQUEST_IMAGE)
        }
        buttonSave.setOnClickListener{
            if (wisata == null) wisata = Wisata()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE && resultCode == Activity.RESULT_OK && data != null){
            val imageUrl = data.data?.toString()
            addEditGambar.setText(imageUrl)
            wisata?.apply {
                dataName = addEditName.text.toString()
                dataDesc = addEditDesc.text.toString()
                if(dataImage == null){
                    addEditGambar.text.toString()
                }
                val intent = Intent()
                intent.putExtra(MainActivity.KEY_WISATA,wisata)
                setResult(Activity.RESULT_OK,intent)
                finish()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}