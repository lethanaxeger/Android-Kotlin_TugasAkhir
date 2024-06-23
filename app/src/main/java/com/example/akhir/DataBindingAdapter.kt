package com.example.akhir

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object DataBindingAdapter{

    @BindingAdapter("android:src")
    fun setImageResoruce(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }
}