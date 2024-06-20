package com.example.akhir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MakananDetailsFragment : Fragment() {

    companion object {
        fun newInstance(): MakananDetailsFragment {
            return MakananDetailsFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_makanan_details, container, false)
    }
}