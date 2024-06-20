package com.example.akhir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class JajanDetailsFragment : Fragment() {

    companion object{
        fun newInstance(): JajanDetailsFragment {
            return JajanDetailsFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_jajan_details, container, false)
    }
}