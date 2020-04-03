package com.example.projectsetup.ui.navigation.fragment.saved.forsale.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsetup.R
import com.example.projectsetup.databinding.RecyclerviewForSaleSavedBinding
import com.example.projectsetup.ui.navigation.fragment.saved.forsale.model.ForSaleSavedModel

class ForSaleSavedAdapter : RecyclerView.Adapter<ForSaleSavedAdapter.ForSaleSavedViewHolder>() {
    var itemList=ArrayList<ForSaleSavedModel>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ForSaleSavedAdapter.ForSaleSavedViewHolder {

        val itemBinding:RecyclerviewForSaleSavedBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.recyclerview_for_sale_saved,parent,false)
        return ForSaleSavedViewHolder(itemBinding)

    }

    override fun getItemCount(): Int =itemList.size

    override fun onBindViewHolder(
        holder: ForSaleSavedAdapter.ForSaleSavedViewHolder,
        position: Int
    ) {
        holder.mBinding.model=itemList[position]
    }

    inner class ForSaleSavedViewHolder(val mBinding:RecyclerviewForSaleSavedBinding ):RecyclerView.ViewHolder(mBinding.root)

    fun addAll(itemList:ArrayList<ForSaleSavedModel>){
        this.itemList=itemList
        notifyDataSetChanged()

    }

}

