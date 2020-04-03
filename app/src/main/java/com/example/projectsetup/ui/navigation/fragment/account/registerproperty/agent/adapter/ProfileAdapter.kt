package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsetup.R
import com.example.projectsetup.databinding.AgentProfileListRecyclerviewBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.model.ProfileListModel
import kotlinx.android.synthetic.main.agent_profile_list_recyclerview.view.*

class ProfileAdapter:RecyclerView.Adapter<ProfileAdapter.MyViewHolder>() {

    var itemList=ArrayList<ProfileListModel>()
    lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.MyViewHolder {

        context=parent.context
        val itemBinding:AgentProfileListRecyclerviewBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context)
            ,R.layout.agent_profile_list_recyclerview,parent,false)

        return MyViewHolder(itemBinding)

    }

    override fun getItemCount(): Int =itemList.size

    override fun onBindViewHolder(holder: ProfileAdapter.MyViewHolder, position: Int) {
        holder.mBinding.model=itemList[position]
    }

    inner class MyViewHolder(val mBinding:AgentProfileListRecyclerviewBinding):RecyclerView.ViewHolder(mBinding.root)

    fun addAll(itemList:ArrayList<ProfileListModel>){
        var size =this.itemList.size
        this.itemList=itemList
        var sizeNew=this.itemList.size
        notifyDataSetChanged()
        fun onClick(){

        }

    }


}