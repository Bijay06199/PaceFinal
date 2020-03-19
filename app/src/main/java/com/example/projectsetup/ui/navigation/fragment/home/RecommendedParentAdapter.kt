package com.example.projectsetup.ui.navigation.fragment.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsetup.R
import kotlinx.android.synthetic.main.recommended_property_parent.view.*

class RecommendedParentAdapter(private val recommendedParents : List<RecommendedParentModel>) :    RecyclerView.Adapter<RecommendedParentAdapter.ViewHolder>(){
    private val viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recommended_property_parent,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return recommendedParents.size
    }

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        val parent = recommendedParents[position]
        val childLayoutManager = LinearLayoutManager( holder.recyclerView.context, RecyclerView.HORIZONTAL, false)
        childLayoutManager.initialPrefetchItemCount = 4
        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            adapter = RecommendedChildAdapter(parent.recommendedChildren)
            setRecycledViewPool(viewPool)
        }

    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val recyclerView : RecyclerView = itemView.recyclerview_reccommended_child

    }
}