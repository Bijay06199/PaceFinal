package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsetup.R
import com.example.projectsetup.databinding.MyPropertyRecyclerviewBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.models.PropertyItemsModel

class MyPropertyAdapter(private val listener:OnItemClickListener):RecyclerView.Adapter<MyPropertyAdapter.MyPropertyViewHolder>() {

    var propertyList=ArrayList<PropertyItemsModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPropertyViewHolder {

        val itemsbinding:MyPropertyRecyclerviewBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context)
            ,R.layout.my_property_recyclerview,parent,false)

        return MyPropertyViewHolder(itemsbinding)

    }

    override fun getItemCount(): Int =propertyList.size


    override fun onBindViewHolder(holder: MyPropertyViewHolder, position: Int) {

        holder.mBinding.model=propertyList[position]
        holder.mBinding.ivRoom.setOnClickListener{

            listener.onItemClicked(holder.adapterPosition,propertyList[holder.adapterPosition])

        }
    }

    interface OnItemClickListener{
        fun onItemClicked(position: Int,poperty:PropertyItemsModel)
    }



    inner class MyPropertyViewHolder(val mBinding:MyPropertyRecyclerviewBinding):RecyclerView.ViewHolder(mBinding.root)

    fun addAll(propertyList:ArrayList<PropertyItemsModel>){
        this.propertyList=propertyList
        notifyDataSetChanged()

    }


}