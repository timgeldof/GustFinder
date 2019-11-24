package com.timgeldof.gustfinder.screens.place_detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.timgeldof.gustfinder.R
import com.timgeldof.gustfinder.database.GustDatabase
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.databinding.PlaceDetailFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class PlaceDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<PlaceDetailFragmentBinding>(inflater, R.layout.place_detail_fragment, container, false)
        binding.lifecycleOwner = this

        val place = PlaceDetailFragmentArgs.fromBundle(arguments!!).selectedPlace
        val viewModelFactory = PlaceDetailViewModelFactory(place)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(PlaceDetailViewModel::class.java)

        binding.placeDetailViewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = PlaceDetailAdapter()
        binding.forecastRecyclerView.adapter = adapter
        viewModel.weather.observe(this, Observer {
            adapter.data = it
        })

        return binding.root;


    }


}
