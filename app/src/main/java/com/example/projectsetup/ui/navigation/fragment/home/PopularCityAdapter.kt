package com.example.projectsetup.ui.navigation.fragment.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsetup.R
import com.example.projectsetup.databinding.FragmentRegisterPropertyMapBinding
import com.example.projectsetup.databinding.PopularCitiesBinding
import kotlinx.android.synthetic.main.popular_cities.view.*

class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    var productList=ArrayList<Product>()
   lateinit var context:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        context=parent.context

        val citiesBinding:PopularCitiesBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context)
            ,R.layout.popular_cities,parent,false)



        return ProductViewHolder(citiesBinding)
    }

    override fun getItemCount(): Int =productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        holder.mBinding.model=productList[position]

//        holder.mBinding.iv_profile.setImageDrawable(ContextCompat.getDrawable(context,productList[position].image))
//
//      // Glide.with(context).load(R.drawable.rectangle).into(holder.itemView.iv_profile)
//        holder.mBinding.itemView.tv_name.text=productList[position].name


    }

    inner class ProductViewHolder(val mBinding:PopularCitiesBinding):RecyclerView.ViewHolder(mBinding.root)


    fun addAll(productList:ArrayList<Product>) {

        this.productList=productList
        notifyDataSetChanged()  //reflect the change for another dataset
    }

    fun onClick(view: View){


    }


}

