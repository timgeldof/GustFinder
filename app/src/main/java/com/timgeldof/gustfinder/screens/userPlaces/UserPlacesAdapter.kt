package com.timgeldof.gustfinder.screens.userPlaces

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timgeldof.gustfinder.R
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.databinding.PlaceItemBinding

class UserPlacesAdapter(private val onClickDetailListener: OnClickListener, private val onClickDeleteListener: OnClickListener) : ListAdapter<Place, UserPlacesAdapter.PlaceViewHolder>(PlacesCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PlaceItemBinding.inflate(layoutInflater, parent, false)
        val view = layoutInflater.inflate(R.layout.place_item, parent, false)
        return PlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place = getItem(position)
        holder.binding.place = place
        holder.binding.txtCityName.setOnClickListener {
            onClickDetailListener.onClick(place)
        }
        holder.binding.deleteButton.setOnClickListener {
            onClickDeleteListener.onClick(place)
        }
    }

    class PlaceViewHolder(val binding: PlaceItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val cityName: TextView = binding.txtCityName
        val country: TextView = binding.txtCountry
    }

    class OnClickListener(val clickListener: (place: Place) -> Unit) {
        fun onClick(place: Place) = clickListener(place)
    }
    class PlacesCallBack() : DiffUtil.ItemCallback<Place>() {
        override fun areItemsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem.placeId == newItem.placeId
        }

        override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem == newItem
        }
    }
}