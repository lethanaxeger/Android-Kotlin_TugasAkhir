package com.example.akhir

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.akhir.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPagerAdapter = ViewPageAdapter(supportFragmentManager, lifecycle)

        with(binding){
            viewPager.adapter = viewPagerAdapter

            TabLayoutMediator(tabLayout, viewPager) {tab, position ->
                when(position){
                    0 -> tab.text = "Jajan"
                    1 -> tab.text = "Makanan"
                }
            }.attach()
        }

    }

}