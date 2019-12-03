package com.timgeldof.gustfinder.screens.add_place

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.databinding.AddPlaceItemBinding
import com.timgeldof.gustfinder.network.models.search_api.Result

class AddPlaceAdapter(private val onClickListener: OnClickListener) : ListAdapter<Result, AddPlaceAdapter.PlaceViewHolder>(ResultCallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AddPlaceItemBinding.inflate(layoutInflater, parent, false)
        return PlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val item = getItem(position)
        val place = Place(
            item.getArea(),
            item.getCountry(),
            item.getRegion(),
            item.getLon(),
            item.getLat()
        )
        holder.binding.place = place
        holder.binding.button.setOnClickListener{
            onClickListener.onClick(place)
        }

    }

    class PlaceViewHolder(val binding: AddPlaceItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val cityName: TextView = binding.txtCityName
        val countryISO: TextView = binding.txtCountry
    }
    class OnClickListener(val clickListener: (place: Place) -> Unit){
        fun onClick(place:Place) = clickListener(place)
    }
    class ResultCallBack : DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.weatherUrl == newItem.weatherUrl
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.latitude == newItem.latitude && oldItem.longitude == newItem.longitude
        }


    }
}
