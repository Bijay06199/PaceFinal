package com.example.projectsetup.ui.navigation.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsetup.R
import com.example.projectsetup.databinding.ReccommendedPropertyChildBinding
import kotlinx.android.synthetic.main.reccommended_property_child.view.*

class RecommendedChildAdapter ( private val itemList:ArrayList<RecommendedChildModel>,private val listener:OnItemClickListener):RecyclerView.Adapter<RecommendedChildAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedChildAdapter.ViewHolder {

        val v:ReccommendedPropertyChildBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.context)
            ,R.layout.reccommended_property_child,parent,false)
        return ViewHolder(v)


    }

    override fun getItemCount(): Int =itemList.size

    override fun onBindViewHolder(holder: RecommendedChildAdapter.ViewHolder, position: Int) {
        holder.mBinding.model=itemList[position]


        holder.mBinding.root.setOnClickListener{
            listener.onChildClicked(holder.adapterPosition,itemList[holder.adapterPosition])
        }


    }


    interface OnItemClickListener{
      //  fun onParentClicked(position: Int,childItems:RecommendedChildModel)
        fun onChildClicked(position: Int,childItems:RecommendedChildModel)
    }



    inner class ViewHolder(val mBinding:ReccommendedPropertyChildBinding):RecyclerView.ViewHolder(mBinding.root){
//        val textView1:TextView=itemView.tv1
//        val textView2:TextView=itemView.tv2
//        val textView3:TextView=itemView.tv3
//        val imageView:ImageView=itemView.iv_room

    }


}