package com.example.akhir

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.akhir.databinding.RecyclerItemFoodModelBinding

class MakananFragment : Fragment() {

    private lateinit var imageResIds: IntArray
    private lateinit var names: Array<String>
    private lateinit var descriptions: Array<String>
    private lateinit var listener: OnMakananSelected

    companion object {
        fun newInstance(): MakananFragment {
            return MakananFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnMakananSelected) {
            listener = context
        } else {
            throw ClassCastException(context.toString() + " must implement OnMakananSelected.")
        }

        // Get food names and descriptions.
        val resources = context.resources
        names = resources.getStringArray(R.array.names)
        descriptions = resources.getStringArray(R.array.descriptions)

        // Get food images.
        val typedArray = resources.obtainTypedArray(R.array.images)
        val imageCount = names.size
        imageResIds = IntArray(imageCount)
        for (i in 0 until imageCount) {
            imageResIds[i] = typedArray.getResourceId(i, 0)
        }
        typedArray.recycle()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_makanan, container,
            false)
        val activity = activity as Context
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        recyclerView.adapter = FoodListAdapter(activity)
        return view
    }

    internal inner class FoodListAdapter(context: Context) : RecyclerView.Adapter<ViewHolder>() {

        private val layoutInflater = LayoutInflater.from(context)

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val recyclerFoodModelBinding =
                RecyclerItemFoodModelBinding.inflate(layoutInflater, viewGroup, false)
            return ViewHolder(recyclerFoodModelBinding.root, recyclerFoodModelBinding)
        }

        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            val food = MakananModel(imageResIds[position], names[position],
                descriptions[position])
            viewHolder.setData(food)
            viewHolder.itemView.setOnClickListener { listener.onMakananSelected(food) }
        }

        override fun getItemCount() = names.size
    }

    internal inner class ViewHolder constructor(itemView: View,
                                                private val recyclerItemFoodListBinding:
                                                RecyclerItemFoodModelBinding
    ) :
        RecyclerView.ViewHolder(itemView) {

        fun setData(makananModel: MakananModel) {
            recyclerItemFoodListBinding.makananModel = makananModel
        }
    }

    interface OnMakananSelected {
        fun onMakananSelected(makananModel: MakananModel)
    }
}
