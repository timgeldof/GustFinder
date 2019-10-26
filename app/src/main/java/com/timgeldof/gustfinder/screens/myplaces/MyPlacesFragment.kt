package com.timgeldof.gustfinder.screens.myplaces


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.timgeldof.gustfinder.R
import com.timgeldof.gustfinder.databinding.MyPlacesFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class MyPlacesFragment : Fragment() {


    private lateinit var binding: MyPlacesFragmentBinding
    private lateinit var viewModel : MyPlacesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<MyPlacesFragmentBinding>(inflater,
            R.layout.my_places_fragment, container, false)


        // viewmodelprovider associates viewmodel with 'this' fragment, when it's called again. It will return the same viewmodel
        Log.i("MyPlacesViewModel","ViewmodelProviders of called")
        viewModel = ViewModelProviders.of(this).get(MyPlacesViewModel::class.java)
        binding.addPlaceButton.setOnClickListener{
            viewModel.addPlace()
        }
        viewModel.myPlaces.observe(this, Observer {
            myPlaces -> binding.textPlaces.text = myPlaces.joinToString()
        })

        return binding.root
    }



}
