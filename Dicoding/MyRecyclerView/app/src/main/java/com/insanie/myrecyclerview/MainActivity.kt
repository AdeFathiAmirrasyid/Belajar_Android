package com.insanie.myrecyclerview


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvOnePiece : RecyclerView
    private var list: ArrayList<OnePiece> = arrayListOf()
    private var title: String = "Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBarTitle(title)

        rvOnePiece = findViewById(R.id.rv_onePiece)
        rvOnePiece.setHasFixedSize(true)

        list.addAll(OnePieceData.listData)
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                title = "Mode List"
                showRecyclerList()
            }
            R.id.action_grid -> {
                title = "Mode Grid"
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                title = "Mode CardView"
                showRecyclerCardView()
            }
        }
        setActionBarTitle(title)
    }

    private fun showRecyclerList() {
        rvOnePiece.layoutManager = LinearLayoutManager(this)
        val listOnePieceAdapter = ListOnePieceAdapter(list)
        rvOnePiece.adapter = listOnePieceAdapter

        listOnePieceAdapter.setOnItemClickCallback(object : ListOnePieceAdapter.OnItemClickCallback {
            override fun onItemClicked(data: OnePiece) {
                showSelectedHero(data)
            }
        })

    }

    private fun showRecyclerGrid() {
        rvOnePiece.layoutManager = GridLayoutManager(this, 2)
        val gridOnePieceAdapter = GridOnePieceAdapter(list)
        rvOnePiece.adapter = gridOnePieceAdapter

        gridOnePieceAdapter.setOnItemClickCallback(object : GridOnePieceAdapter.OnItemClickCallback {
            override fun onItemClicked(data: OnePiece) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerCardView() {
        rvOnePiece.layoutManager = LinearLayoutManager(this)
        val cardViewOnePieceAdapter = CardViewOnePieceAdapter(list)
        rvOnePiece.adapter = cardViewOnePieceAdapter
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun showSelectedHero(onePiece: OnePiece) {
        Toast.makeText(this, "Kamu memilih " + onePiece.data_name, Toast.LENGTH_SHORT).show()
    }

}