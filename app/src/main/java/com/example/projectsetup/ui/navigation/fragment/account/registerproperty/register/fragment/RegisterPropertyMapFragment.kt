package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.FragmentRegisterPropertyMapBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyMapViewModel
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.SupportMapFragment








class RegisterPropertyMapFragment :
    BaseFragment<FragmentRegisterPropertyMapBinding, RegisterPropertyMapViewModel>(),
    OnMapReadyCallback {

    private val registerPropertyMapViewModel: RegisterPropertyMapViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_register_property_map

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

    private var mMap: GoogleMap? = null
    private var mCurrLocationMarker: Marker? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initGMaps()
        initView()
        setUpObservers()
    }

    private fun setUpObservers() {

        with(registerPropertyMapViewModel) {

            btnClickEvent.observe(viewLifecycleOwner, Observer {
                RegisterPropertyDetailFragment.start(activity!!,R.id.container_register_property)


            })


            ivBackClickEvent.observe(viewLifecycleOwner, Observer {
                fragmentManager!!.popBackStack()
            })


        }
    }


    private fun initView() {


    }


    private fun initGMaps() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)


    }


    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap
        var latitude = 34.6937
        var longitude = 135.5023

        val latLng = LatLng(latitude, longitude)
        val markerOptions = MarkerOptions()

       // markerOptions.position(latLng)
       // markerOptions.title("Rent in Osaka")
        mMap?.addMarker(MarkerOptions().position(latLng).title("Rent in Osaka"))
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.locationmarker))

      //  mCurrLocationMarker = mMap!!.addMarker(markerOptions)

        val markerOptions2 = MarkerOptions()

        markerOptions2.position(LatLng(35.6762, 139.6503))
        markerOptions2.title("Rent in Tokyo")
        markerOptions2.icon(BitmapDescriptorFactory.fromResource(R.drawable.locationmarker))

        mCurrLocationMarker = mMap!!.addMarker(markerOptions2)

        //move map camera
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        mMap!!.animateCamera(CameraUpdateFactory.zoomTo(11F))

    }

    companion object {
        var mapFragment:SupportMapFragment?=null
        val TAG = "RegisterPropertyRelationship Fragment"
        fun start(activity: FragmentActivity, containerId: Int) {
            val fragment = RegisterPropertyMapFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(TAG)
                .commit()

        }

    }


}



