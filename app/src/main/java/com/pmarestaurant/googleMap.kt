package com.pmarestaurant

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class googleMap : AppCompatActivity() {
    lateinit var mapFragment : SupportMapFragment
    lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_map)
        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap=it
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            )
            googleMap.isMyLocationEnabled = true

            val location1 =LatLng(44.787578771145846, 20.436393998013155)
            googleMap.addMarker(MarkerOptions().position(location1).title("Restoran 27"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1,13f))


            val location2 =LatLng(44.80519007178285, 20.402010998013786)
            googleMap.addMarker(MarkerOptions().position(location2).title("Despacito"))

            val location3 =LatLng(44.80977008048502, 20.480328124999836)
            googleMap.addMarker(MarkerOptions().position(location3).title("Lorenzo & Kakalamba"))

            val location4 =LatLng(44.814027454834466, 20.450223011507074)
            googleMap.addMarker(MarkerOptions().position(location4).title("Miradouro"))


            val location5 =LatLng(44.90921706836942, 20.47170444301415)
            googleMap.addMarker(MarkerOptions().position(location5).title("Tri šešira"))

            val location6 =LatLng(44.78826855424662, 20.498918924999206)
            googleMap.addMarker(MarkerOptions().position(location6).title("Legat 1903"))

        })
            }
}