package com.timgeldof.gustfinder

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.timgeldof.gustfinder.screens.add_place.ApiStatus


        @BindingAdapter("apiStatus")
        fun ImageView.setStatus(status: ApiStatus?) {
            when (status) {
                ApiStatus.LOADING -> {
                    this.visibility = View.VISIBLE
                    setImageResource(R.drawable.loading_animation)
                }
                ApiStatus.ERROR -> {
                    this.visibility = View.VISIBLE
                    setImageResource(R.drawable.empty_box)
                }
                ApiStatus.DONE -> {
                    this.visibility = View.GONE
                }
            }
        }

