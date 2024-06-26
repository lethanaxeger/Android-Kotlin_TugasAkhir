package com.example.akhir

import android.hardware.SensorEventListener
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), MakananFragment.OnFoodSelected {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.root_layout, MakananFragment.newInstance(), "makananList")
                .commit()
        }
    }
    override fun onFoodSelected(makananModel: MakananModel) {
        val detailsFragment =
            MakananDetailsFragment.newInstance(makananModel)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.root_layout, detailsFragment, "makananDetails")
            .addToBackStack(null)
            .commit()
    }
}