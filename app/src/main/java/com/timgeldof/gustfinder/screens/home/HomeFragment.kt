package com.timgeldof.gustfinder.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.timgeldof.gustfinder.R
import com.timgeldof.gustfinder.databinding.HomeFragmentBinding

/**
 * First [Fragment] in the navhost fragment which contains a menu for navigation
 */
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: HomeFragmentBinding = DataBindingUtil.inflate(inflater,
            R.layout.home_fragment, container, false)

        binding.textMyPlaces.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_myPlacesFragment))
        binding.textMyMap.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_userMapFragment))
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return NavigationUI.onNavDestinationSelected(
            item,
            view!!.findNavController()) ||
                super.onOptionsItemSelected(item)
    }
}
