package com.timgeldof.gustfinder.screens.place_detail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timgeldof.gustfinder.databinding.PlaceDetailFragmentBinding
import com.timgeldof.gustfinder.databinding.PlaceDetailItemBinding
import com.timgeldof.gustfinder.network.models.marine_weather_api.Weather

class PlaceDetailAdapter : RecyclerView.Adapter<PlaceDetailViewHolder>(){

    var data = listOf<Weather>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceDetailViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PlaceDetailItemBinding.inflate(layoutInflater, parent, false)
        return PlaceDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceDetailViewHolder, position: Int) {
        Log.i("API","reached on bindviewholder")
        holder.binding.weather = data[position]
        Log.i("API","bind weather info of date: " + data[position].date)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}
class PlaceDetailViewHolder(val binding: PlaceDetailItemBinding) : RecyclerView.ViewHolder(binding.root) {
}