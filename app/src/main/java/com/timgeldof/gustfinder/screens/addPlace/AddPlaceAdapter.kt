package com.timgeldof.gustfinder.screens.addPlace

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.databinding.AddPlaceItemBinding
import com.timgeldof.gustfinder.network.models.searchApi.Result
/**
 * Adapts Place objects to be shown in the recyclerview of the Add Place screen
 *
 * @param onClickListener [OnClickListener] that is used to bind to a button which adds a place to the places_table in the database
 * @return The result of executing the operation
 */
class AddPlaceAdapter(private val onClickListener: OnClickListener) : ListAdapter<Result, AddPlaceAdapter.PlaceViewHolder>(ResultCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AddPlaceItemBinding.inflate(layoutInflater, parent, false)
        return PlaceViewHolder(binding)
    }
    /**
     * Binds the [Place] object to the viewholder
     * @param holder
     * @param position the position of the data element in the listadapter data list
     */
    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(getItem(position), onClickListener)
    }
    /**
     * Contains the binding object of [AddPlaceItemBinding] class and is responsible for binding the result of the API
     * @param binding The binding object of the Add Place Item XML
     */
    class PlaceViewHolder(val binding: AddPlaceItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Result, onClickListener: OnClickListener) {
            val place = Place(
                item.getArea(),
                item.getCountry(),
                item.getRegion(),
                item.getLon(),
                item.getLat()
            )
            binding.place = place
            binding.button.setOnClickListener {
                onClickListener.onClick(place)
            }
        }
    }
    /**
     * Contains an onClick method used to bind a clickListener to the [AddPlaceItemBinding] with the Place instance
     *
     * @param clickListener named lambda used to set the click listener
     */
    class OnClickListener(val clickListener: (place: Place) -> Unit) {
        fun onClick(place: Place) = clickListener(place)
    }
    /**
     * Used to see if the [Result] differs from the previous data elements to optimize resource usage
     */
    class ResultCallBack : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.weatherUrl == newItem.weatherUrl
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.latitude == newItem.latitude && oldItem.longitude == newItem.longitude
        }
    }
}
