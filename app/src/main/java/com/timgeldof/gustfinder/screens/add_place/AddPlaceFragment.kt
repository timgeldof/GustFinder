package com.timgeldof.gustfinder.screens.add_place


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.timgeldof.gustfinder.R
import com.timgeldof.gustfinder.database.GustDatabase
import com.timgeldof.gustfinder.databinding.AddPlaceFragmentBinding
import com.timgeldof.gustfinder.databinding.UserPlacesFragmentBinding
import com.timgeldof.gustfinder.setStatus
import kotlinx.coroutines.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class AddPlaceFragment : Fragment() {

    private var viewModelJob = Job()
    private val uiScope  = CoroutineScope(Dispatchers.Main + viewModelJob)

    private lateinit var binding: AddPlaceFragmentBinding
    private lateinit var viewModel : AddPlaceViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<AddPlaceFragmentBinding>(inflater,
            R.layout.add_place_fragment, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = GustDatabase.getInstance(application).placeDatabaseDao
        binding.setLifecycleOwner(this)

        val viewModelFactory = AddPlaceViewModelFactory(dataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AddPlaceViewModel::class.java)
        binding.viewModel =  viewModel
        binding.searchResultRecyclerview.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)


        val adapter = AddPlaceAdapter(AddPlaceAdapter.OnClickListener{
            uiScope.launch {
                viewModel.insertPlaceIntoDatabase(it)
            }
            findNavController().navigate(AddPlaceFragmentDirections.actionAddPlaceFragmentToMyPlacesFragment())
        })

        binding.searchResultRecyclerview.adapter = adapter


        /*
        ** SOURCE: https://medium.com/@pro100svitlo/edittext-debounce-with-kotlin-coroutines-fd134d54f4e9
        */
        binding.addPlaceTextField.addTextChangedListener(object : TextWatcher {
            var searchFor: String = ""
            override fun afterTextChanged(editable: Editable?) {
                var searchText = editable.toString()
                if (searchText == searchFor)
                    return
                searchFor = searchText
                uiScope.launch {
                    delay(600)  //debounce timeOut
                    if (searchText != searchFor)
                        return@launch
                    viewModel.getSearchResults(searchFor)
                }
            }
            override fun beforeTextChanged(c: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(c: CharSequence?, start: Int, count: Int, after: Int) {}
        })

        viewModel.response.observe(viewLifecycleOwner, Observer {
            it?.let{
                adapter.data = it.search_api!!.result
            }
        })
        return binding.root
    }


}
