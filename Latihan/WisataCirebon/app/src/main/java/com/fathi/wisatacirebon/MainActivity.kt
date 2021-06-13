package com.fathi.wisatacirebon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //saat gambar HOME diKLIK munculkan HOMEACTIVITY

        home.setOnClickListener{
            //munculkan menu home
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        portal.setOnClickListener{
            val intent = Intent(this,PortalWisata::class.java)
            startActivity(intent)
        }
        lokasi.setOnClickListener{
            val intent = Intent(this,LokasiActivity::class.java)
            startActivity(intent)
        }
        vidio.setOnClickListener{
            val intent = Intent(this,com.fathi.wisatacirebon.vidio ::class.java)
            startActivity(intent)
        }
        galeri.setOnClickListener{
            val intent =   Intent (this,com.fathi.wisatacirebon.galeri::class.java)
            startActivity(intent)
        }
        tentang.setOnClickListener{
            val intent = Intent(this,com.fathi.wisatacirebon.tentang::class.java)
            startActivity(intent)
        }

    }
}
