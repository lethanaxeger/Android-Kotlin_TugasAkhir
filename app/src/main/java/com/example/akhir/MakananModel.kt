package com.example.akhir

import java.io.Serializable

data class MakananModel(val imageResId: Int,
                    val name: String,
                    val description: String,
                    var text: String = "") : Serializable