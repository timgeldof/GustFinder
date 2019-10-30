package com.timgeldof.gustfinder.screens.userplaces

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.timgeldof.gustfinder.R
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.databinding.PlaceItemBinding

class UserPlacesAdapter: RecyclerView.Adapter<UserPlacesAdapter.PlaceViewHolder>() {

    var data = listOf<Place>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PlaceItemBinding.inflate(layoutInflater, parent, false)
        val view = layoutInflater.inflate(R.layout.place_item, parent, false)
        return PlaceViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val item = data[position]
        holder.cityName.text = item.city
        holder.countryISO.text = item.countryCodeISO
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class PlaceViewHolder(val binding: PlaceItemBinding): RecyclerView.ViewHolder(binding.root){
        val cityName: TextView = binding.txtCityName
        val countryISO: TextView = binding.txtCountryIso
    }

}

