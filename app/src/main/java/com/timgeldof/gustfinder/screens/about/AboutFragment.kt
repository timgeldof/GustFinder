package com.timgeldof.gustfinder.screens.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.timgeldof.gustfinder.R
import com.timgeldof.gustfinder.databinding.AboutFragmentBinding

/**
 * A subclass of [Fragment] that inflates an view which shows you information about the app.
 */
class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<AboutFragmentBinding>(inflater,
            R.layout.about_fragment, container, false)
        return binding.root
    }
}
