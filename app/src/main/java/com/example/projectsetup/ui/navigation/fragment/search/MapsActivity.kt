package com.example.projectsetup.ui.navigation.fragment.search

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.media.audiofx.BassBoost
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.location.LocationManagerCompat.isLocationEnabled
import com.example.projectsetup.R
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.ResultCallback
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.*
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import java.security.AccessController.checkPermission




class MapsActivity : AppCompatActivity(), OnMapReadyCallback/*, LocationListener,
    GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener*/ {
//    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
//
//    }
//
//    override fun onProviderEnabled(provider: String?) {
//
//    }
//
//    override fun onProviderDisabled(provider: String?) {
//
//    }

    private var mMap: GoogleMap? = null
    private lateinit var mLastLocation: Location
    internal lateinit var mLocationResult: LocationRequest
    private lateinit var mLocationCallback: LocationCallback
    private var mCurrLocationMarker: Marker? = null
    private var mGoogleApiClient: GoogleApiClient? = null
    private lateinit var mLocationRequest: LocationRequest
    private var mFusedLocationClient: FusedLocationProviderClient? = null
    private lateinit var mapFragment:MapFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_search)
        initGMaps()


    }

    private fun initGMaps() {
        mapFragment = fragmentManager.findFragmentById(R.id.map) as MapFragment
        mapFragment.getMapAsync(this)


    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        var latitude=36.2048
        var longitude=138.2529

        val latLng = LatLng(latitude,longitude)
        val markerOptions = MarkerOptions()

        markerOptions.position(latLng)
        markerOptions.title("Current Position")
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.locationmarker))

        mCurrLocationMarker = mMap!!.addMarker(markerOptions)

        //move map camera
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        mMap!!.animateCamera(CameraUpdateFactory.zoomTo(11f))



//        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (ContextCompat.checkSelfPermission(this,
//                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                buildGoogleApiClient()
//                mMap!!.isMyLocationEnabled = true
//            }
//        } else {
//            buildGoogleApiClient()
//            mMap!!.isMyLocationEnabled = true
//        }

    }

//    @Synchronized
//    protected fun buildGoogleApiClient() {
//        mGoogleApiClient = GoogleApiClient.Builder(this)
//            .addConnectionCallbacks(this)
//            .addOnConnectionFailedListener(this)
//            .addApi(LocationServices.API).build()
//        mGoogleApiClient!!.connect()
//    }
//
//
//    override fun onConnected(bundle: Bundle?) {
//
//        mLocationRequest = LocationRequest()
//        mLocationRequest.interval = 1000
//        mLocationRequest.fastestInterval = 1000
//        mLocationRequest.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
//        if (ContextCompat.checkSelfPermission(this,
//                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
//           // mFusedLocationClient?.requestLocationUpdates(mLocationRequest,)
//        }
//    }
//
//    override fun onLocationChanged(location: Location) {
//
//        mLastLocation = location
//        if (mCurrLocationMarker != null) {
//            mCurrLocationMarker!!.remove()
//        }
//        //Place current location marker
//        val latLng = LatLng(location.latitude, location.longitude)
//        val markerOptions = MarkerOptions()
//        markerOptions.position(latLng)
//        markerOptions.title("Current Position")
//        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.savedheart))
//
//        mCurrLocationMarker = mMap!!.addMarker(markerOptions)
//
//        //move map camera
//        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
//        mMap!!.animateCamera(CameraUpdateFactory.zoomTo(11f))
//
//        //stop location updates
//        if (mGoogleApiClient != null) {
//            mFusedLocationClient?.removeLocationUpdates(mLocationCallback)
//        }
//    }
//
//
//    override fun onConnectionFailed(connectionResult: ConnectionResult) {
//        Toast.makeText(applicationContext,"connection failed", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onConnectionSuspended(p0: Int) {
//        Toast.makeText(applicationContext,"connection suspended", Toast.LENGTH_SHORT).show()
//    }
}
















