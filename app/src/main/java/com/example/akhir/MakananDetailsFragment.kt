package com.example.akhir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.akhir.databinding.FragmentMakananDetailsBinding


class MakananDetailsFragment : Fragment() {

    companion object {

        private const val MAKANANMODEL= "model"
        fun newInstance(makananModel: MakananModel): MakananDetailsFragment {
            val args = Bundle()
            args.putSerializable(MAKANANMODEL, makananModel)
            val fragment = MakananDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentMakananDetailsBinding =
            FragmentMakananDetailsBinding.inflate(inflater, container, false)

        val model = arguments?.getSerializable(MAKANANMODEL) as MakananModel
        fragmentMakananDetailsBinding.makananModel = model
        model.text = String.format(getString(R.string.description_format), model.description)
        return fragmentMakananDetailsBinding.root
    }
}