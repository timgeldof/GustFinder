package com.timgeldof.gustfinder


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.timgeldof.gustfinder.databinding.HomeFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: HomeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment,container, false)

        binding.textMyPlaces.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_myPlacesFragment))
        return binding.root
    }


}
