package com.example.akhir

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MakananModel(
    val imageResId: Int,
    val name: String,
    val description: String,
    var text: String? = null
) : Parcelable