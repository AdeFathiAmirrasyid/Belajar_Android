package com.fathi.wisatacirebon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class galeri : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var adapter : GaleriAdapter
    lateinit var  lm : RecyclerView.LayoutManager

    val url = arrayOf(
        "https://akcdn.detik.net.id/community/media/visual/2019/10/29/02335a2e-1a99-45ec-9ff3-055d7333b511.jpeg?a=1",
        "https://www.worldofghibli.id/wp-content/uploads/2019/08/gambar-pemandangan-cantik-1-e1565192597200.jpg")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeri)

        recyclerView = findViewById(R.id.recyclerViewGaleri)

        recyclerView.setHasFixedSize(true)
        lm = GridLayoutManager(this,1)
        recyclerView.layoutManager = lm

        adapter = GaleriAdapter(url, this)
        recyclerView.adapter= adapter

    }
}
