package com.example.mrrexz.mytaxiandroid.util

import android.databinding.BindingAdapter
import android.view.View
import android.widget.TextView


@BindingAdapter("android:setTextDouble")
fun setTextDouble(textView: TextView, value: Double) {
    textView.text = value.toString()
}
