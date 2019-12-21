package com.timgeldof.gustfinder.screens.placeDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timgeldof.gustfinder.database.realm.RealmWeather
import com.timgeldof.gustfinder.databinding.PlaceDetailItemBinding
import com.timgeldof.gustfinder.network.models.marineWeatherApi.Weather

class PlaceDetailAdapter : ListAdapter<RealmWeather, PlaceDetailAdapter.PlaceDetailViewHolder>(RealmWeatherDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceDetailViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PlaceDetailItemBinding.inflate(layoutInflater, parent, false)
        return PlaceDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceDetailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    class PlaceDetailViewHolder(val binding: PlaceDetailItemBinding) : RecyclerView.ViewHolder(binding.root) {
        /**
         * Binds the [Weather] parameter to the [PlaceDetailItemBinding]
         *
         * @param weather returned by the marine weather api
         */
        fun bind(weather: RealmWeather) {
            binding.weather = weather
        }
    }
    /**
     * Callback class used to calculate the difference between two [Weather] lists for optimizing the recyclerview efficiency.
     */
    class RealmWeatherDiffCallback : DiffUtil.ItemCallback<RealmWeather>() {
        override fun areItemsTheSame(oldItem: RealmWeather, newItem: RealmWeather): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: RealmWeather, newItem: RealmWeather): Boolean {
            return false
        }
    }
}
