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
//        var item= itemList[position]
//        holder.itemView.iv_list.setImageDrawable(ContextCompat.getDrawable(context,item.image))
//        holder.itemView.tv_list1.text=item.text1
//        holder.itemView.tv_list2.text=item.text2
//        holder.itemView.tv_list3.text=item.text3
    }

    inner class MyViewHolder(val mBinding:AgentProfileListRecyclerviewBinding):RecyclerView.ViewHolder(mBinding.root)

    fun addAll(itemList:ArrayList<ProfileListModel>){
        this.itemList=itemList
        notifyDataSetChanged()

        fun onClick(){

        }

    }


}