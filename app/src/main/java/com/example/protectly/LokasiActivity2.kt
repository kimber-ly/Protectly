package com.example.protectly

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.protectly.databinding.ActivityLokasi2Binding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.Task

class LokasiActivity2 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityLokasi2Binding
    private lateinit var currentLocation: Location
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLokasi2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        getLastLocation()
    }

    private fun getLastLocation(){
        Log.d("MyApp", "Starting location request")
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.d("MyApp", "Location permission not granted")
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                Companion.FINE_PERMISSION_CODE
            )
            return
        }
        Log.d("MyApp", "Requesting last location")
        val task: Task<Location> = fusedLocationProviderClient.lastLocation
        task.addOnSuccessListener {
            Log.d("MyApp", "onSuccess")
            if (it != null){
                currentLocation = it

                // Obtain the SupportMapFragment and get notified when the map is ready to be used.
                val mapFragment = supportFragmentManager
                    .findFragmentById(R.id.map) as SupportMapFragment
                mapFragment.getMapAsync(this)
            }
            else {
                Log.d("MyApp", "Location is null")
            }
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        if (currentLocation != null) {
            val lokasiku = LatLng(currentLocation.latitude, currentLocation.longitude)
            mMap.addMarker(MarkerOptions().position(lokasiku).title("Lokasiku"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(lokasiku))
        }
        else {
            Log.e("MyApp", "currentLocation is null in onMapReady")
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == Companion.FINE_PERMISSION_CODE){
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getLastLocation()
            }
            else {
                Toast.makeText(this, "Location permission is denied, please " +
                        "allow the permission", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val FINE_PERMISSION_CODE = 1
    }
}