package com.timgeldof.gustfinder.screens.user_map

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.timgeldof.gustfinder.databinding.MyPlacesMapFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class UserMapFragment : Fragment(), OnMapReadyCallback {

    lateinit var userMapView : MyPlacesMapFragmentBinding
    lateinit var myGoogleMap : GoogleMap
    lateinit var mapView: MapView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = MyPlacesMapFragmentBinding.inflate(inflater, container, false)

        userMapView = binding

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView = userMapView.mapView
        if(mapView!=null){
            mapView.onCreate(null)
            mapView.onResume()
            mapView.getMapAsync(this)
        }


    }

    override fun onMapReady(googleMap: GoogleMap?) {
        MapsInitializer.initialize(context)

        myGoogleMap = googleMap!!
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL

        val marker = myGoogleMap.addMarker(MarkerOptions().position(LatLng(52.3,3.20)))
        marker.title = "Wherever"
        marker.snippet = "I don't give a damn"

    }





}
