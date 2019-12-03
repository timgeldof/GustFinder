package com.timgeldof.gustfinder.screens.place_detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearSnapHelper
import com.timgeldof.gustfinder.R
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
        val snapHelper = LinearSnapHelper()

        val adapter = PlaceDetailAdapter()
        binding.forecastRecyclerView.adapter = adapter
        snapHelper.attachToRecyclerView(binding.forecastRecyclerView)

        viewModel.weather.observe(this, Observer {
            adapter.submitList(it)
        })

        Toast.makeText(context, "Swipe right for more", Toast.LENGTH_LONG).show()

        return binding.root;

    }


}
