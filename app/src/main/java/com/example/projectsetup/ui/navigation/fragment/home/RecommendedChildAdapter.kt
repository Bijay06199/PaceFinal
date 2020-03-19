package com.example.projectsetup.ui.navigation.fragment.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsetup.R
import kotlinx.android.synthetic.main.reccommended_property_child.view.*

class RecommendedChildAdapter (private val recommendedChildren:List<RecommendedChildModel>):RecyclerView.Adapter<RecommendedChildAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedChildAdapter.ViewHolder {

        val v= LayoutInflater.from(parent.context)
            .inflate(R.layout.reccommended_property_child,parent,false)
        return ViewHolder(v)


    }

    override fun getItemCount(): Int =recommendedChildren.size

    override fun onBindViewHolder(holder: RecommendedChildAdapter.ViewHolder, position: Int) {

        var child= recommendedChildren[position]
        holder.imageView.setImageResource(child.image)
        holder.textView1.text=child.title1
        holder.textView2.text=child.title2
        holder.textView3.text=child.title3


    }


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView1:TextView=itemView.tv1
        val textView2:TextView=itemView.tv2
        val textView3:TextView=itemView.tv3
        val imageView:ImageView=itemView.iv_room

    }
}