package com.example.projectsetup.ui.navigation.fragment.saved.all.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsetup.R
import com.example.projectsetup.databinding.RecyclerviewAllSavedBinding
import com.example.projectsetup.ui.navigation.fragment.saved.all.model.AllModel
import kotlinx.android.synthetic.main.all_saved_fragment.view.*


class AllSavedAdapter :RecyclerView.Adapter<AllSavedAdapter.AllViewHolder>(){
    var allSavedList=ArrayList<AllModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllSavedAdapter.AllViewHolder {
        val listBinding:RecyclerviewAllSavedBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.recyclerview_all_saved,parent, false)
        return AllViewHolder(listBinding)

    }

    override fun getItemCount(): Int =allSavedList.size

    override fun onBindViewHolder(holder: AllSavedAdapter.AllViewHolder, position: Int) {
        holder.mBinding.model=allSavedList[position]
    }


    inner class AllViewHolder(val mBinding:RecyclerviewAllSavedBinding):RecyclerView.ViewHolder(mBinding.root)

    fun addAll(allSavedList:ArrayList<AllModel>){
        this.allSavedList=allSavedList
        notifyDataSetChanged()

    }
}