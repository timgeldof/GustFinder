package com.timgeldof.gustfinder.screens.userMap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.timgeldof.gustfinder.database.GustDatabase
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.databinding.MyPlacesMapFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class UserMapFragment : Fragment(), OnMapReadyCallback {

    lateinit var binding: MyPlacesMapFragmentBinding
    lateinit var myGoogleMap: GoogleMap
    lateinit var mapView: MapView
    lateinit var viewModel: UserMapViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = MyPlacesMapFragmentBinding.inflate(inflater, container, false)
        val database = GustDatabase.getInstance(context!!).placeDatabaseDao
        val viewModelFactory = UserMapViewModelFactory(database)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserMapViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView = binding.mapView
        if (mapView != null) {
            mapView.onCreate(null)
            mapView.getMapAsync(this)
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        mapView.onDestroy()
        super.onDestroy()
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        MapsInitializer.initialize(context)
        myGoogleMap = googleMap!!
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        viewModel.myPlaces.observe(this,
            Observer {
                    places ->
                for (place in places) {
                    placeMarker(place)
                }
            }
        )
    }

    private fun placeMarker(place: Place) {
        var marker = myGoogleMap.addMarker(
            MarkerOptions().position(
                LatLng(
                    place.latitude.toDouble(),
                    place.longitude.toDouble()
                )
            )
        )
        marker.title = place.area
        marker.snippet = place.region
    }
}
