package com.insanie.wisata_indonesia

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPref: SharedPref


    companion object {
        const val REQUEST_ADD = 100
        const val REQUEST_EDIT = 200
        const val REQUEST_REMOVE = 300
        const val KEY_WISATA = "wisata"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = SharedPref(this)



        recyclerView.layoutManager = LinearLayoutManager(this)
        val list = WisataData.list
        val adapter = WisataAdapter(list, sharedPref)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

        adapter.onItemClickListener = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(KEY_WISATA, it)
            startActivity(intent)
        }
        buttonAdd.setOnClickListener {
            val intent = Intent(this, AddEditActivity::class.java)
            startActivityForResult(intent, REQUEST_ADD)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_ADD && resultCode == Activity.RESULT_OK && data != null)
            //todo tambah data
            Toast.makeText(this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        recyclerView.layoutManager = if (sharedPref.gridLayout && sharedPref.getColomn > 0) {
            GridLayoutManager(this, sharedPref.getColomn)
        } else {
            LinearLayoutManager(this)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuSetting -> startActivity(Intent(this, Setting::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}