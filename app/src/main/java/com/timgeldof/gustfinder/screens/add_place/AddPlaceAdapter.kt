package com.timgeldof.gustfinder.screens.add_place

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.timgeldof.gustfinder.R
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.databinding.AddPlaceItemBinding
import com.timgeldof.gustfinder.databinding.PlaceItemBinding
import com.timgeldof.gustfinder.network.models.Result

class AddPlaceAdapter(private val onClickListener: OnClickListener) : RecyclerView.Adapter<AddPlaceAdapter.PlaceViewHolder>() {

    var data = listOf<Result>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AddPlaceItemBinding.inflate(layoutInflater, parent, false)
        return PlaceViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val item = data[position]
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

    override fun getItemCount(): Int {
        return data.size
    }

    class PlaceViewHolder(val binding: AddPlaceItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val cityName: TextView = binding.txtCityName
        val countryISO: TextView = binding.txtCountry
    }
    class OnClickListener(val clickListener: (place: Place) -> Unit){
        fun onClick(place:Place) = clickListener(place)
    }
}
