package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseActivity
import com.example.projectsetup.databinding.ActivityRegisterPropertyMapBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyMapViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyMapActivity :
    BaseActivity<ActivityRegisterPropertyMapBinding, RegisterPropertyMapViewModel>(),
    OnMapReadyCallback {

    private val registerPropertyMapViewModel: RegisterPropertyMapViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.activity_register_property_map

    override fun getViewModel(): RegisterPropertyMapViewModel = registerPropertyMapViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


//    private lateinit var mLastLocation: Location
//    internal lateinit var mLocationResult: LocationRequest
//    private lateinit var mLocationCallback: LocationCallback
//    private var mGoogleApiClient: GoogleApiClient? = null
//    private lateinit var mLocationRequest: LocationRequest
//    private var mFusedLocationClient: FusedLocationProviderClient? = null

    private lateinit var mapFragment: MapFragment
    private var mMap: GoogleMap? = null
    private var mCurrLocationMarker: Marker? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_register_property_map)
        initGMaps()
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {

        with(registerPropertyMapViewModel) {

            btnClickEvent.observe(this@RegisterPropertyMapActivity, Observer {

                startActivity(
                    Intent(
                        this@RegisterPropertyMapActivity,
                        RegisterPropertyDetailActivity::class.java
                    )
                )
            })
        }
    }


    private fun initView() {


    }


    private fun initGMaps() {
        mapFragment = fragmentManager.findFragmentById(R.id.map) as MapFragment
        mapFragment.getMapAsync(this)


    }


    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap
        var latitude = 34.6937
        var longitude = 135.5023

        val latLng = LatLng(latitude, longitude)
        val markerOptions = MarkerOptions()

        markerOptions.position(latLng)
        markerOptions.title("Rent in Osaka")
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.locationmarker))

        mCurrLocationMarker = mMap!!.addMarker(markerOptions)

        val markerOptions2 = MarkerOptions()

        markerOptions2.position(LatLng(35.6762, 139.6503))
        markerOptions2.title("Rent in Tokyo")
        markerOptions2.icon(BitmapDescriptorFactory.fromResource(R.drawable.locationmarker))

        mCurrLocationMarker = mMap!!.addMarker(markerOptions2)

        //move map camera
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        mMap!!.animateCamera(CameraUpdateFactory.zoomTo(11F))

    }

}
