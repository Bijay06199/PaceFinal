package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsetup.R
import com.example.projectsetup.databinding.RecyclerviewSecondparentPhotoBinding
import com.example.projectsetup.databinding.SinglePhotoLayoutBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.models.MySinglePhotoModel

class PhotoChildAdapter( private var itemList:ArrayList<MySinglePhotoModel>,private val listener:OnItemClickListener):RecyclerView.Adapter<PhotoChildAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val mBinding:SinglePhotoLayoutBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.single_photo_layout,parent,false)
        return MyViewHolder(mBinding)

    }

    override fun getItemCount(): Int =itemList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mBinding.model=itemList[position]
        holder.mBinding.ivProfile.setOnClickListener{
            listener.onItemClicked(holder.adapterPosition,itemList[holder.adapterPosition])
        }

        holder.mBinding.ivDelete.setOnClickListener {
            listener.onDeleteClicked(holder.adapterPosition,itemList[holder.adapterPosition])
        }


    }

    fun addAll(itemList:ArrayList<MySinglePhotoModel>){
        this.itemList=itemList
        notifyDataSetChanged()
    }

    fun remove(position: Int){
        this.itemList.removeAt(position)
    }


    interface OnItemClickListener{
        fun onItemClicked(position: Int,itemList:MySinglePhotoModel)
        fun onDeleteClicked(position: Int,itemList: MySinglePhotoModel)
    }

    inner class MyViewHolder(val mBinding:SinglePhotoLayoutBinding):RecyclerView.ViewHolder(mBinding.root)


}