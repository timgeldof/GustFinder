package com.timgeldof.gustfinder

import android.content.res.Resources
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.timgeldof.gustfinder.network.networkAvailable
import com.timgeldof.gustfinder.screens.addPlace.ApiStatus
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

/**
 *  This binding adapter sets the visibility and the image source that corresponds to the return value of the api request
 *
 * @param status: the status of the api request
 */
@BindingAdapter("apiStatus")
        fun ImageView.setStatus(status: ApiStatus?) {
            when (status) {
                ApiStatus.LOADING -> {
                    this.visibility = View.VISIBLE
                    setImageResource(R.drawable.loading_animation)
                }
                ApiStatus.ERROR -> {
                    this.visibility = View.VISIBLE
                    setImageResource(R.drawable.empty_box)
                    if(status == ApiStatus.ERROR){
                        if(!networkAvailable(this.context!!)){
                            Toast.makeText(this.context!!, "Internet not available", Toast.LENGTH_LONG).show()
                        }
                    }
                }
                ApiStatus.DONE -> {
                    this.visibility = View.GONE
                }
            }
        }
/**
 *  This binding adapter sets the source of the image with Glide
 *  Glide caches this image for optimization
 * @param url: the url of the image resource
 */
@BindingAdapter("glideSrc")
fun ImageView.setResource(url: String?) {
    try{
        Glide.with(this.context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(this)
    } catch (ex: GlideException){
        this.setImageResource(R.drawable.wind_icon)
    }

}
/**
 *  Formats the date with the English Locale
 *  @param text: the url of the image resource
 */
@BindingAdapter("dateFormatted")
fun TextView.SetDateFormatted(text: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val date: LocalDate = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val formattedDate: String = date.dayOfWeek.name.toLowerCase() + " " + date.dayOfMonth.toString() + " " + date.month.getDisplayName(TextStyle.FULL, Locale.ENGLISH).toLowerCase()
        this.setText(formattedDate)
    } else {
        this.setText(text)
    }
}
