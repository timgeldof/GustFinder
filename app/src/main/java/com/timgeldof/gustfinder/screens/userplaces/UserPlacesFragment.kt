package com.timgeldof.gustfinder.screens.userplaces


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
import com.timgeldof.gustfinder.database.GustDatabase
import com.timgeldof.gustfinder.databinding.UserPlacesFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class UserPlacesFragment : Fragment() {


    private lateinit var binding: UserPlacesFragmentBinding
    private lateinit var viewModel : UserPlacesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<UserPlacesFragmentBinding>(inflater,
            R.layout.user_places_fragment, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = GustDatabase.getInstance(application).placeDatabaseDao
        val viewModelFactory = UserPlacesViewModelFactory(dataSource, application )


        // viewmodelprovider associates viewmodel with 'this' fragment, when it's called again. It will return the same viewmodel
        Log.i("UserPlacesViewModel","ViewmodelProviders of called")
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UserPlacesViewModel::class.java)
        binding.userPlacesViewModel = viewModel
        binding.setLifecycleOwner(this)

        return binding.root
    }



}
