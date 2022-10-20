package com.uaref.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.service_ui.R
import com.uaref.model.DaysOfWeek

@BindingAdapter("setDay")
fun setItems(view: TextView, day: DaysOfWeek?) {
    day?.let {
        when (day) {
            is DaysOfWeek.Sunday -> view.setText(R.string.sunday)
            is DaysOfWeek.Monday -> view.setText(R.string.monday)
            is DaysOfWeek.Tuesday -> view.setText(R.string.tuesday)
            is DaysOfWeek.Wednesday -> view.setText(R.string.wednesday)
            is DaysOfWeek.Thursday -> view.setText(R.string.thursday)
            is DaysOfWeek.Friday -> view.setText(R.string.friday)
            is DaysOfWeek.Saturday -> view.setText(R.string.saturday)
            is DaysOfWeek.NonSelected -> view.setText(R.string.day_not_select)
        }
    }
}
