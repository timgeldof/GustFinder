package com.timgeldof.gustfinder.screens.userPlaces

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.timgeldof.gustfinder.database.Place
import com.timgeldof.gustfinder.databinding.PlaceItemBinding
/**
 * A [ListAdapter] subclass
 *
 * @param onClickDetailListener An OnClickListener parameter that is used to show the detail of the place
 * @param onClickDeleteListener An OnClickListener parameter that is used to set the delete action on the delete button
 */
class UserPlacesAdapter(private val onClickDetailListener: OnClickListener, private val onClickDeleteListener: OnClickListener) : ListAdapter<Place, UserPlacesAdapter.PlaceViewHolder>(PlacesCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PlaceItemBinding.inflate(layoutInflater, parent, false)
        return PlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place = getItem(position)
        holder.bind(place, onClickDetailListener, onClickDeleteListener)
    }

    class PlaceViewHolder(val binding: PlaceItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(place: Place, onClickDetailListener: OnClickListener, onClickDeleteListener: OnClickListener) {
            binding.place = place
            binding.placeContent.setOnClickListener {
                onClickDetailListener.onClick(place)
            }
            binding.deleteButton.setOnClickListener {
                onClickDeleteListener.onClick(place)
            }
        }
    }

    class OnClickListener(val clickListener: (place: Place) -> Unit) {
        fun onClick(place: Place) = clickListener(place)
    }
    /**
     * Callback class used to calculate the difference between two [Place] lists for optimizing the [RecyclerView] updating efficiency.
     */
    class PlacesCallBack() : DiffUtil.ItemCallback<Place>() {
        override fun areItemsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem.placeId == newItem.placeId
        }

        override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem == newItem
        }
    }
}
