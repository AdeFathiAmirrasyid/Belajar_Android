package com.insanie.apprecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_cardview_onepiece.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // source code ini untuk menampilkan halaman utama listView(RecyclerVIew)
        recyclerview_onepiece.layoutManager = LinearLayoutManager(this)
        val list = DataOnePiece.list_onepiece
        val adapterOnePiece = ListAdapterOnePiece(list)
        recyclerview_onepiece.adapter = adapterOnePiece
        recyclerview_onepiece.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

        // source code ini untuk pindah ke halaman detail activity
        adapterOnePiece.onItemClickListener = {
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(KEY_ONEPIECE, it)
            startActivity(intent)
        }
    }
    // source code ini untuk menampilkan menu items
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    // source code ini untuk action dari menu ke detail,listview,cardview
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    // source code ini untuk action dari menu ke detail,listview,cardview
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.menuList -> {
                showRecyclerList()
            }
            R.id.menuCard -> {
                showRecyclerCardView()
            }
            R.id.menuItems -> {
                startActivity(Intent(this@MainActivity, AboutActivity::class.java))
            }
        }
    }

    // source code ini untuk function dari recyclerview
    private fun showRecyclerList() {
        recyclerview_onepiece.layoutManager = LinearLayoutManager(this)
        val list = DataOnePiece.list_onepiece
        val listAdapterOnePiece = ListAdapterOnePiece(list)
        recyclerview_onepiece.adapter = listAdapterOnePiece


        // source code ini untuk action dari menu ke listview
        val adapterOnePiece = ListAdapterOnePiece(list)
        recyclerview_onepiece.adapter = adapterOnePiece
        recyclerview_onepiece.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))


        // source code ini untuk action dari menu ke Detail activity
        adapterOnePiece.onItemClickListener = {
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(KEY_ONEPIECE, it)
            startActivity(intent)
        }
    }

    // source code ini untuk function dari cardview
    private fun showRecyclerCardView() {
        recyclerview_onepiece.layoutManager = LinearLayoutManager(this)
        val list = DataOnePiece.list_onepiece
        val cardViewOnePieceAdapter = CardViewOnePieceAdapter(list)
        recyclerview_onepiece.adapter = cardViewOnePieceAdapter

        // source code ini untuk action click button di detail activity
        cardViewOnePieceAdapter.setOnItemClickCallback(object :
            CardViewOnePieceAdapter.OnItemClickCallback {
            override fun onItemClicked(data: ModelOnePiece) {
                showSelectedOnePieceDetail(data)
            }
            override fun onItemClickedShere(sendIntent: Intent) {
                showSelectedOnePieceShere()
            }
        })
    }
    // source code ini untuk function button yang ada di detailActivity pake metode callback dari cardviewActivity
    private fun showSelectedOnePieceDetail(onePiece: ModelOnePiece) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(KEY_ONEPIECE, onePiece)
        startActivity(intent)
    }
    // source code ini untuk function button yang ada di detailActivity pake metode callback dari cardviewActivity
    private fun showSelectedOnePieceShere() {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, data)
            type = "text/plain"
        }
        startActivity(sendIntent)
    }

    // source code ini untuk key value dari dataOnePiece dan ModelOnePiece
    companion object {
        const val KEY_ONEPIECE = "modelOnePiece"
    }

}