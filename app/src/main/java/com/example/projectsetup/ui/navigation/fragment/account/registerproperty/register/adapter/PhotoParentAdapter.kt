package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsetup.R
import com.example.projectsetup.databinding.RecyclerviewSecondparentPhotoBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.models.SecondParentPhotoModel
import kotlinx.android.synthetic.main.recyclerview_secondparent_photo.view.*

class PhotoParentAdapter(private var itemListParent:ArrayList<SecondParentPhotoModel>,private val listener: PhotoChildAdapter.OnItemClickListener,private val listenerparent:OnItemCLickListenerParent):RecyclerView.Adapter<PhotoParentAdapter.PhotoViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val mBinding:RecyclerviewSecondparentPhotoBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.recyclerview_secondparent_photo,parent, false)
        return PhotoViewHolder(mBinding)
    }

    override fun getItemCount(): Int =itemListParent.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.mBinding.model=itemListParent[position]
        val parent=itemListParent[position]

        val childLayoutManager=LinearLayoutManager(holder.recyclerViewSinglePhoto.context,RecyclerView.HORIZONTAL,false)
        childLayoutManager.initialPrefetchItemCount=1
        holder.recyclerViewSinglePhoto.apply {
            layoutManager=childLayoutManager
            adapter=PhotoChildAdapter(parent.photoChildren,listener)
            setRecycledViewPool(viewPool)

            holder.mBinding.ivAdd.setOnClickListener {
                listenerparent.onItemClickedParent(holder.adapterPosition,itemListParent[holder.adapterPosition])
            }

            holder.mBinding.ivDelete.setOnClickListener {
                listenerparent.onDeleteClickedParent(holder.adapterPosition,itemListParent[holder.adapterPosition])
            }
        }
    }

    fun addAll(itemList:ArrayList<SecondParentPhotoModel>){
        this.itemListParent=itemList
    }

    fun remove(position: Int){
        this.itemListParent.removeAt(position)
    }
    inner class PhotoViewHolder(val mBinding:RecyclerviewSecondparentPhotoBinding):RecyclerView.ViewHolder(mBinding.root){
        val recyclerViewSinglePhoto:RecyclerView=itemView.recyclerView_secondparent_photo
    }
}
interface OnItemCLickListenerParent {
    fun onItemClickedParent(position: Int, itemList: SecondParentPhotoModel)
    fun onDeleteClickedParent(position: Int, itemList: SecondParentPhotoModel)
}
