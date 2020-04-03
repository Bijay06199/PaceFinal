package com.example.projectsetup.ui.navigation.fragment.saved.forrent.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsetup.R
import com.example.projectsetup.databinding.RecyclerviewForRentSavedBinding
import com.example.projectsetup.ui.navigation.fragment.saved.forrent.model.ForRentSavedModel

class ForRentSavedAdapter:RecyclerView.Adapter<ForRentSavedAdapter.ForRentSavedViewHolder>() {
    var itemList=ArrayList<ForRentSavedModel>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ForRentSavedAdapter.ForRentSavedViewHolder {
        val rentBinding:RecyclerviewForRentSavedBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.recyclerview_for_rent_saved,parent, false)
        return ForRentSavedViewHolder(rentBinding)

    }

    override fun getItemCount(): Int =itemList.size

    override fun onBindViewHolder(holder: ForRentSavedAdapter.ForRentSavedViewHolder, position: Int) {
        holder.mBinding.model=itemList[position]
    }

    inner class ForRentSavedViewHolder(val mBinding:RecyclerviewForRentSavedBinding):RecyclerView.ViewHolder(mBinding.root)

    fun addAll(itemList:ArrayList<ForRentSavedModel>){
        this.itemList=itemList
        notifyDataSetChanged()
    }
}


