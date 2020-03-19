package com.example.projectsetup.ui.navigation.fragment.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.projectsetup.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
     var recyclerView1=recyclerview_reccommended_parent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {

      recyclerView1=recyclerview_reccommended_parent

        recyclerView1.apply {
            layoutManager=LinearLayoutManager(activity,RecyclerView.VERTICAL,false)

            adapter=RecommendedParentAdapter(RecommendedParentDataFactory.getParents(40))
        }

        val productAdapter=ProductAdapter()
        recyclerView.adapter=productAdapter

        var productList=ArrayList<Product>()

        productList.add(Product("Tokyo",R.drawable.rectangle))
        productList.add(Product("Nara",R.drawable.rectangle14))
        productList.add(Product("Akhibara",R.drawable.rectangle149))
        productList.add(Product("Okinaw",R.drawable.rectangle1492))
        productList.add(Product("Geman",R.drawable.rectangle))
        productList.add(Product("France",R.drawable.rectangle14))
        productList.add(Product("Akhibara",R.drawable.rectangle149))
        productList.add(Product("Sochua",R.drawable.rectangle1492))


        productAdapter.addAll(productList)

    }


}
