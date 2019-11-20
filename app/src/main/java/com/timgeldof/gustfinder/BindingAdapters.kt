package com.timgeldof.gustfinder

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timgeldof.gustfinder.network.models.ApiSearchResponse
import com.timgeldof.gustfinder.network.models.Result
import com.timgeldof.gustfinder.screens.add_place.AddPlaceAdapter
import com.timgeldof.gustfinder.screens.add_place.ApiStatus

class BindingAdapters {

    companion object {
        @BindingAdapter("bind:listData")
        @JvmStatic
        fun bindRecyclerView(recyclerView: RecyclerView, data: ApiSearchResponse) {
            val adapter = recyclerView.adapter as AddPlaceAdapter
            adapter.data = data.search_api!!.result
        }

        @BindingAdapter("bind:apiStatus")
        @JvmStatic
        fun bindStatus(statusImageView: ImageView, status: ApiStatus?) {
            when (status) {
                ApiStatus.LOADING -> {
                    statusImageView.visibility = View.VISIBLE
                    statusImageView.setImageResource(R.drawable.loading_animation)
                }
                ApiStatus.ERROR -> {
                    statusImageView.visibility = View.VISIBLE
                    statusImageView.setImageResource(R.drawable.empty_box)
                }
                ApiStatus.DONE -> {
                    statusImageView.visibility = View.GONE
                }
            }
        }

    }
}