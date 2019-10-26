package com.timgeldof.gustfinder.screens.myplaces


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.timgeldof.gustfinder.R
import com.timgeldof.gustfinder.databinding.MyPlacesFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class MyPlacesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<MyPlacesFragmentBinding>(inflater,
            R.layout.my_places_fragment, container, false)
        return binding.root
    }


}
