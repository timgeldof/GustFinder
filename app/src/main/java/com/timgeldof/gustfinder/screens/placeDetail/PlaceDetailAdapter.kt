package com.timgeldof.gustfinder.screens.placeDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timgeldof.gustfinder.databinding.PlaceDetailItemBinding
import com.timgeldof.gustfinder.network.models.marineWeatherApi.Weather

class PlaceDetailAdapter : ListAdapter<Weather, PlaceDetailAdapter.PlaceDetailViewHolder>(WeatherDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceDetailViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PlaceDetailItemBinding.inflate(layoutInflater, parent, false)
        return PlaceDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceDetailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    class PlaceDetailViewHolder(val binding: PlaceDetailItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(weather: Weather) {
            binding.weather = weather
        }
    }
    class WeatherDiffCallback : DiffUtil.ItemCallback<Weather>() {
        override fun areItemsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem.hourly == newItem.hourly
        }
    }
}
