package com.timgeldof.gustfinder.screens.userPlaces

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.timgeldof.gustfinder.R
import com.timgeldof.gustfinder.database.GustDatabase
import com.timgeldof.gustfinder.databinding.UserPlacesFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class UserPlacesFragment : Fragment() {

    private lateinit var binding: UserPlacesFragmentBinding
    private lateinit var viewModel: UserPlacesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<UserPlacesFragmentBinding>(inflater,
            R.layout.user_places_fragment, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = GustDatabase.getInstance(application).placeDatabaseDao
        val viewModelFactory = UserPlacesViewModelFactory(dataSource, application)
        binding.setLifecycleOwner(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserPlacesViewModel::class.java)
        binding.userPlacesViewModel = viewModel
        val adapter = UserPlacesAdapter(
            UserPlacesAdapter.OnClickListener {
                viewModel.displayPlaceDetails(it)
            },
            UserPlacesAdapter.OnClickListener {
                viewModel.removePlaceFromDatabase(it)
                viewModel.getPlacesFromDB()
            }
        )
        binding.recyclerView.adapter = adapter
        viewModel.myPlaces.observe(viewLifecycleOwner,
            Observer {
                    places ->
                        adapter.submitList(places)
            }
        )

        viewModel.navigateToSelectedPlace.observe(viewLifecycleOwner,
            Observer {
                place ->
                    if (place != null) {
                        findNavController()
                            .navigate(UserPlacesFragmentDirections.actionMyPlacesFragmentToPlaceDetailFragment(place))
                        viewModel.displayPlaceDetailsComplete()
                    }
            }
        )
        binding.addPlaceButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_myPlacesFragment_to_addPlaceFragment))
        return binding.root
    }
}
