package com.insanie.wisata_indonesia

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.zip.Inflater

class DetailActivity : AppCompatActivity() {

    var wisata: Wisata? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        wisata = intent.getParcelableExtra<Wisata>(MainActivity.KEY_WISATA)
        populate(wisata)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }

    }

    fun populate(wisata: Wisata?) {
        wisata?.apply {
            textView1.text = dataName
            textView2.text = dataDesc
            detailImage.setImageResource(dataImage)
        }

        supportActionBar?.apply {
            title = wisata?.dataName

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MainActivity.REQUEST_EDIT && resultCode == Activity.RESULT_OK && data != null){
            wisata = data.getParcelableExtra(MainActivity.KEY_WISATA)
            populate(wisata)
            Toast.makeText(this, "Data Berhasil Di edit", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_edit -> {
                val intent = Intent(this, AddEditActivity::class.java)
                intent.putExtra(MainActivity.KEY_WISATA, wisata)
                startActivityForResult(intent, MainActivity.REQUEST_EDIT)
            }
            R.id.menu_remove -> {
                AlertDialog.Builder(this)
                    .setMessage("Apakah anda yakin mengapus item ini")
                    .setPositiveButton("ya") { _, _ ->
                        //todo hapus data
                        Toast.makeText(this, "Data berhasil di hapus", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    .setNegativeButton("Tidak", null)
                    .show()
            }
            else -> {
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}