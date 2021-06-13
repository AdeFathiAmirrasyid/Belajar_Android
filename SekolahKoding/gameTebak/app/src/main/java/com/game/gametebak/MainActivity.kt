package com.game.gametebak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.game.gametebak.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        val navCtrl = this.findNavController(R.id.navHost_fragment)
        NavigationUI.setupActionBarWithNavController(this,navCtrl)
        NavigationUI.setupWithNavController(binding.bottomNav,navCtrl)
    }
    override fun onSupportNavigateUp(): Boolean {
        var navCtrl = this.findNavController(R.id.navHost_fragment)
        return navCtrl.navigateUp()
    }
}