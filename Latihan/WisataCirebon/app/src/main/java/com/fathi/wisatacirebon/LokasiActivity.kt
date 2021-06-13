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


class LokasiActivity : AppCompatActivity(),OnMapReadyCallback, View.OnClickListener {

    private lateinit var mapp : GoogleMap
    lateinit var mp  : SupportMapFragment
    lateinit var normall : Button
    lateinit var satellitee : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lokasi)

        mp = this.supportFragmentManager.findFragmentById(R.id.mapsfragment) as SupportMapFragment
        mp.getMapAsync(this)

        normall = findViewById(R.id.normal)
        satellitee= findViewById(R.id.satellite)


        normall.setOnClickListener(this)
        satellitee.setOnClickListener(this)

    }
    override fun onMapReady(p0: GoogleMap?) {

        var  mallCsb : LatLng
        var  grageMall : LatLng
        var  tirtaIndah : LatLng
        var  Haigar     : LatLng
        mapp = p0!!

        mallCsb = LatLng(-6.7184428,108.5474848)
        grageMall = LatLng(-6.7135055,108.5493744)
        tirtaIndah = LatLng(-6.7765678,108.3831696)
        Haigar      = LatLng(-6.8745746,108.4123694)

        mapp.addMarker(MarkerOptions().position(Haigar).title("Kolam Renang Hegar"))
        mapp.moveCamera(CameraUpdateFactory.newLatLngZoom(Haigar,10F))

        mapp.addMarker(MarkerOptions().position(tirtaIndah).title("Kolam Renang Tirta Indah"))
        mapp.moveCamera(CameraUpdateFactory.newLatLngZoom(tirtaIndah,10F))

        mapp.addMarker(MarkerOptions().position(mallCsb).title("CSB"))
        mapp.moveCamera(CameraUpdateFactory.newLatLngZoom(mallCsb,10F))

        mapp.addMarker(MarkerOptions().position(grageMall).title("Grage Mall"))
        mapp.moveCamera(CameraUpdateFactory.newLatLngZoom(grageMall,10F))

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
