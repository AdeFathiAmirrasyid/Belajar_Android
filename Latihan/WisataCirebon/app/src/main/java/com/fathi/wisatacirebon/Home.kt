package com.fathi.wisatacirebon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    lateinit var ca : CarouselView
    val sampleImages = intArrayOf(R.drawable.portal, R.drawable.lokasi, R.id.galeri, R.id.vidio)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        ca = findViewById(R.id.carouselView)
        ca.setPageCount(4)
        ca.setImageListener(imageListener)
    }


    var imageListener : ImageListener = object : ImageListener{

        override fun setImageForPosition(position: Int, imageView: ImageView) {
            Glide.with(this@Home).load(sampleImages[position]).into(imageView)
        }
    }




}
