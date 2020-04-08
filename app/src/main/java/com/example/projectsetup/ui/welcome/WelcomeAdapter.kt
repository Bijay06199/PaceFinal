package com.example.projectsetup.ui.welcome

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsetup.databinding.WelcomeRecyclerviewLayoutBinding


class WelcomeAdapter(private val listener: WelcomeAdapter.OnItemClickListener) :
    RecyclerView.Adapter<WelcomeAdapter.WelcomeViewHolder>() {
    var itemList = ArrayList<WelcomeModel>()
    var isClicked: ArrayList<Boolean> = ArrayList()
    lateinit var context: Context
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WelcomeAdapter.WelcomeViewHolder {
        context = parent.context
        val mBinding: WelcomeRecyclerviewLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            com.example.projectsetup.R.layout.welcome_recyclerview_layout, parent, false
        )

        return WelcomeViewHolder(mBinding)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: WelcomeAdapter.WelcomeViewHolder, position: Int) {
        // holder.mBinding.model=itemList[position]
        holder.mBinding.ivTick.visibility = View.GONE

        when (position) {
            position -> holder.mBinding.layoutJapan.setOnClickListener {
                holder.mBinding.ivTick.visibility = View.VISIBLE
            }
        }

        holder.mBinding.ivTick.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                itemList[position].tick
            )
        )
        holder.mBinding.ivCountry.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                itemList[position].image
            )
        )
        holder.mBinding.tvCountry.text = itemList[position].countryName

//
        listener.onItemClicked(holder.adapterPosition, itemList[holder.adapterPosition])
    }

    interface OnItemClickListener {
        fun onItemClicked(position: Int, property: WelcomeModel)

    }

    inner class WelcomeViewHolder(val mBinding: WelcomeRecyclerviewLayoutBinding) :
        RecyclerView.ViewHolder(mBinding.root)

    fun addAll(itemList: ArrayList<WelcomeModel>) {
        this.itemList = itemList
        notifyDataSetChanged()


    }
}