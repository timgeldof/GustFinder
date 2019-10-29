package com.timgeldof.gustfinder.screens.place_detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.timgeldof.gustfinder.R
import com.timgeldof.gustfinder.database.GustDatabase
import com.timgeldof.gustfinder.databinding.PlaceDetailFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class PlaceDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<PlaceDetailFragmentBinding>(inflater, R.layout.place_detail_fragment, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = GustDatabase.getInstance(application).placeDatabaseDao

        val viewModelFactory = PlaceDetailViewModelFactory(0,dataSource)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(PlaceDetailViewModel::class.java)

        binding.placeDetailViewModel = viewModel
        binding.setLifecycleOwner(this)



        return binding.root;


    }


}
