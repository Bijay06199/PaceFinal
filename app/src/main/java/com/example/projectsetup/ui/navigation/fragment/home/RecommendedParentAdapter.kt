package com.example.projectsetup.ui.navigation.fragment.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsetup.R
import com.example.projectsetup.databinding.RecommendedPropertyParentBinding
import kotlinx.android.synthetic.main.recommended_property_parent.view.*
import java.util.*
import kotlin.collections.ArrayList

class RecommendedParentAdapter(private val recommendedParents : List<RecommendedParentModel>,private val listener:RecommendedChildAdapter.OnItemClickListener) :    RecyclerView.Adapter<RecommendedParentAdapter.ViewHolder>(){
    private val viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val v:RecommendedPropertyParentBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context)
            ,R.layout.recommended_property_parent,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int =recommendedParents.size

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        holder.mBinding.model=recommendedParents[position]
       val parent = recommendedParents[position]

        val childLayoutManager = LinearLayoutManager( holder.recyclerView.context, RecyclerView.HORIZONTAL, false)
        childLayoutManager.initialPrefetchItemCount = 4
        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            adapter = RecommendedChildAdapter(parent.recommendedChildren,listener)

            setRecycledViewPool(viewPool)
        }

    }


    inner class ViewHolder(val mBinding :RecommendedPropertyParentBinding) : RecyclerView.ViewHolder(mBinding.root){
        val recyclerView : RecyclerView = itemView.recyclerview_reccommended_child

    }

}