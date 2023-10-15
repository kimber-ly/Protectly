//package com.example.protectly
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.google.android.gms.maps.*
//import com.google.android.gms.maps.model.LatLng
//import com.google.android.gms.maps.model.MarkerOptions
//
//class LokasiActivity : AppCompatActivity(), OnMapReadyCallback {
//
//    private lateinit var mMap: GoogleMap
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_lokasi)
//    }
//
//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//
//        // Konfigurasi peta di sini
//        val location1 = LatLng(13.03,77.60)
//        googleMap.addMarker(MarkerOptions().position(location1).title("My Location"))
//        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1,5f))
//
//        val location2 = LatLng(9.89,78.11)
//        googleMap.addMarker(MarkerOptions().position(location2).title("Madurai"))
//
//
//        val location3 = LatLng(13.00,77.00)
//        googleMap.addMarker(MarkerOptions().position(location3).title("Bangalore"))
//
//    }
//}
