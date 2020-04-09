package com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.fragment

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.core.view.OneShotPreDrawListener.add
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.RecyclerviewParentPhotoBinding
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.adapter.OnItemCLickListenerParent
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.adapter.PhotoChildAdapter
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.adapter.PhotoParentAdapter
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.models.MySinglePhotoModel
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.models.SecondParentPhotoModel
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.RegisterPropertyPhotoViewModel
import com.example.projectsetup.ui.navigation.fragment.home.RecommendedChildDataFactory
import com.example.projectsetup.ui.navigation.fragment.home.RecommendedChildModel
import kotlinx.android.synthetic.main.recyclerview_parent_photo.*
import kotlinx.android.synthetic.main.recyclerview_secondparent_photo.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterPropertyPhotoFragment
    : BaseFragment<RecyclerviewParentPhotoBinding, RegisterPropertyPhotoViewModel>(),
    PhotoChildAdapter.OnItemClickListener,OnItemCLickListenerParent {
    override fun onItemClickedParent(position: Int, itemList: SecondParentPhotoModel) {
        val itemList=ArrayList<SecondParentPhotoModel>()
        itemList.add(SecondParentPhotoModel("Photo for","Add new category",getChildren(1)))
        parentAdapter.addAll(itemList)
        runLayoutAnimation(viewDataBinding.recyclerViewParentPhoto)

    }

    override fun onDeleteClickedParent(position: Int, itemList: SecondParentPhotoModel) {
        parentAdapter.remove(position)
        runLayoutAnimationRight(position,viewDataBinding.recyclerViewParentPhoto)

    }

    private lateinit var parentAdapter: PhotoParentAdapter
    private lateinit var childAdapter: PhotoChildAdapter


    override fun onItemClicked(position: Int, itemList: MySinglePhotoModel) {
        val itemList=ArrayList<MySinglePhotoModel>()
        itemList.add(MySinglePhotoModel(R.drawable.plus,R.drawable.delete))
        childAdapter.addAll(itemList)
        runLayoutAnimation(viewDataBinding.recyclerViewParentPhoto)

    }

    private fun runLayoutAnimation(recyclerView: RecyclerView?) {
        val controller: LayoutAnimationController =
            AnimationUtils.loadLayoutAnimation(
                recyclerView!!.context,
                R.anim.slide_in_left
            )
        recyclerView.layoutAnimation = controller
        recyclerView.adapter!!.notifyDataSetChanged()
        recyclerView.scheduleLayoutAnimation()


    }

    override fun onDeleteClicked(position: Int, itemList: MySinglePhotoModel) {
        childAdapter.remove(position)
        runLayoutAnimationRight(position,viewDataBinding.recyclerViewParentPhoto)
    }

    private fun runLayoutAnimationRight(position: Int, recyclerView: RecyclerView?) {
        val controller: LayoutAnimationController =
            AnimationUtils.loadLayoutAnimation(
                recyclerView!!.context,
                R.anim.slide_in_right
            )
        recyclerView.layoutAnimation = controller
        recyclerView.adapter!!.notifyItemRemoved(position)
        recyclerView.scheduleLayoutAnimation()
    }



    private val registerPropertyPhotoViewModel: RegisterPropertyPhotoViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.recyclerview_parent_photo
    override fun getViewModel(): RegisterPropertyPhotoViewModel = registerPropertyPhotoViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpObservers()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        val recyclerView_parent = recyclerView_parent_photo
        val recyclerView_child = recyclerView_secondparent_photo

     //   viewDataBinding.recyclerViewParentPhoto.adapter = childAdapter

        recyclerView_parent.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            adapter = PhotoParentAdapter(getParents(4,getChildren(1)),this@RegisterPropertyPhotoFragment,this@RegisterPropertyPhotoFragment)
        }
      //  getItems()


    }

    private fun getParents(count:Int,childCount:ArrayList<MySinglePhotoModel>):ArrayList<SecondParentPhotoModel>{
        val parents= ArrayList<SecondParentPhotoModel>()
        repeat(count){
            val parent=SecondParentPhotoModel("Photo for","Add category",childCount )

             childCount.size
            parents.add(parent)
        }
        return parents
    }


    fun getChildren(count:Int):ArrayList<MySinglePhotoModel>{
        val children = ArrayList<MySinglePhotoModel>()
        repeat(count){
            val child= MySinglePhotoModel(R.drawable.plus, R.drawable.delete)
            children.add(child)
        }
        return children
    }


//    private fun getItems() {
//        val itemChild = ArrayList<MySinglePhotoModel>()
//        itemChild.add(
//            MySinglePhotoModel(
//       //         "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
//        //        , R.drawable.delete
//        //    )
//        )
//        childAdapter.addAll(itemChild)
//
//    }

    private fun setUpObservers() {

        with(registerPropertyPhotoViewModel) {

            btnNextClicked.observe(viewLifecycleOwner, Observer {

                RegisterPropertyDescriptionFragment.start(
                    activity!!,
                    R.id.container_register_property
                )

            })

            ivBackClicked.observe(viewLifecycleOwner, Observer {
                fragmentManager!!.popBackStack()

            })

        }

    }

    private fun initView() {

    }

    companion object {
        val TAG = "RegisterPropertyRelationship Fragment"
        fun start(activity: FragmentActivity, containerId: Int) {
            val fragment = RegisterPropertyPhotoFragment()
            activity.supportFragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(TAG)
                .commit()

        }

    }
}