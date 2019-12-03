package com.timgeldof.gustfinder

import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
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
                }
                ApiStatus.DONE -> {
                    this.visibility = View.GONE
                }
            }
        }
@BindingAdapter("glideSrc")
fun ImageView.setResource(url: String) {
    Glide.with(this.context).load(url).into(this)
}
@BindingAdapter("dateFormatted")
fun TextView.SetDateFormatted(text: String) {
    var parsedDate = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val date: LocalDate = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyy-MM-dd"))
        val formattedDate: String = date.dayOfWeek.name.toLowerCase() + " " + date.dayOfMonth.toString() + " " + date.month.getDisplayName(TextStyle.FULL, Locale.ENGLISH).toLowerCase()
        this.setText(formattedDate)
    } else {
        this.setText(text)
    }
}
