package com.fathi.wisatacirebon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class lokasi : AppCompatActivity(), OnMapReadyCallback, View.OnClickListener{


    private lateinit var mapp : GoogleMap
    lateinit var mp  : SupportMapFragment
    lateinit var normall : Button
    lateinit var satellitee : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lokasi)

        mp = this.supportFragmentManager.findFragmentById(R.id.mapsfragment) as SupportMapFragment
        normall = findViewById(R.id.normal)
        satellitee= findViewById(R.id.satellite)


//        normall.setOnClickListener(this)
//        satellitee.setOnClickListener(this)

    }

    override fun onMapReady(p0: GoogleMap?) {
        var kejawanan : LatLng
        var kalijaga : LatLng

        kejawanan = LatLng(-6.733613,108.583602)
        kalijaga= LatLng(-6.7392377,108.5438915)

        mapp.addMarker(MarkerOptions().position(kejawanan).title("Pantai Kejawanan"))
        mapp.moveCamera(CameraUpdateFactory.newLatLngZoom(kejawanan, 10F))

        mapp.addMarker(MarkerOptions().position(kalijaga).title("Kalijags"))
        mapp.moveCamera(CameraUpdateFactory.newLatLngZoom(kalijaga, 10F))
    }

    override fun onClick(v: View?) {
       when(v!!.id){
           R.id.normal->{
            mapp.mapType = GoogleMap.MAP_TYPE_NORMAL
           }
           R.id.satellite ->{
               mapp.mapType = GoogleMap.MAP_TYPE_SATELLITE
           }
       }
    }
}
