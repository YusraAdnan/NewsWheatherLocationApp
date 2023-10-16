package com.newsapi.newswheatherlocationapp.Activites

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.newsapi.newswheatherlocationapp.R

class WheatherScreen : AppCompatActivity() {

    val REQUEST_FINE_LOCATION: Int = 0
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    val city: String = "null"
    val country: String = "null"
    private lateinit var client: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wheather_screen)
        Log.i("WhetherScreen - lat" , ""+ 100000000)
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_FINE_LOCATION)
            }
    else{
            client = LocationServices.getFusedLocationProviderClient(this)
            client.getLastLocation()
                .addOnCompleteListener(this){ task ->
                    if (task.isSuccessful && task.result != null){
                        longitude = task.getResult().longitude
                        latitude = task.getResult().latitude
                        Log.i("WhetherScreen - long", ""+ longitude)
                        Log.i("WhetherScreen - lat" , ""+ latitude)
                    }
                }


    }
    }
}