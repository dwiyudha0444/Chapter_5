package com.dwiyu.chapter_5_androidpermission

import android.content.Context
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dwiyu.chapter_5_androidpermission.databinding.ActivityWifiOnOffBinding

class Wifi_on_off : AppCompatActivity() {
    lateinit var binding: ActivityWifiOnOffBinding
    lateinit var wifiManager: WifiManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWifiOnOffBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonOn.setOnClickListener{
            enableWifi()
        }

        binding.buttonOff.setOnClickListener{
            disableWifi()
        }

        title = "KotlinApp"
    }

    fun enableWifi() {
        val wifiManager = getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiManager.isWifiEnabled = true
        Toast.makeText(this, "Wifi enabled", Toast.LENGTH_SHORT).show()
    }
    fun disableWifi() {
        val wifiManager = getSystemService(Context.WIFI_SERVICE) as WifiManager
        wifiManager.isWifiEnabled = false
        Toast.makeText(this, "Wifi disabled", Toast.LENGTH_SHORT).show()
    }


}
