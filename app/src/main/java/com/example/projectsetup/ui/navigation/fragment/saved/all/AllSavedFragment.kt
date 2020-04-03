package com.example.projectsetup.ui.navigation.fragment.saved.all

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.projectsetup.BR

import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.AllSavedFragmentBinding
import com.example.projectsetup.databinding.AllSavedFragmentBinding.inflate
import com.example.projectsetup.ui.navigation.fragment.saved.all.adapter.AllSavedAdapter
import com.example.projectsetup.ui.navigation.fragment.saved.all.model.AllModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllSavedFragment : BaseFragment<AllSavedFragmentBinding,AllSavedViewModel>() {

    lateinit var allSavedAdapter:AllSavedAdapter
    private val allSavedViewModel:AllSavedViewModel by viewModel()
    override fun getLayoutId(): Int =R.layout.all_saved_fragment
    override fun getViewModel(): AllSavedViewModel =allSavedViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }



    companion object{

        val TAG=AllSavedFragment::class.java.simpleName
        fun start(activity: FragmentActivity, containerId:Int){
            val fragment=AllSavedFragment()
            activity.supportFragmentManager.beginTransaction()
                .addToBackStack(TAG)
                .replace(containerId,fragment)
                .commit()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        allSavedAdapter= AllSavedAdapter()
        viewDataBinding.recyclerViewAllSaved.adapter=allSavedAdapter
        var itemList=ArrayList<AllModel>()
        itemList.add(AllModel("https://cdn.pixabay.com/photo/2016/11/18/14/50/boat-1835081_960_720.jpg","450 W 20th Ave","Shiho city BC","$2300000"))
        itemList.add(AllModel("https://image.shutterstock.com/image-photo/osaka-castle-famous-historical-landmark-260nw-523976515.jpg","450 W 20th Ave","Shiho city BC","$2300000"))
        itemList.add(AllModel("https://cdn.pixabay.com/photo/2017/03/12/21/30/tokyo-2138168__340.jpg","450 W 20th Ave","Shiho city BC","$2300000"))
        itemList.add(AllModel("https://cdn.pixabay.com/photo/2017/02/21/16/48/tokyo-2086596__340.jpg","450 W 20th Ave","Shiho city BC","$2300000"))
        itemList.add(AllModel("https://cdn.pixabay.com/photo/2016/11/18/14/50/boat-1835081_960_720.jpg","450 W 20th Ave","Shiho city BC","$2300000"))
        itemList.add(AllModel("https://cdn.pixabay.com/photo/2015/04/16/15/22/japan-725802__340.jpg","450 W 20th Ave","Shiho city BC","$2300000"))
        itemList.add(AllModel("https://cdn.pixabay.com/photo/2016/09/12/19/02/phlox-1665461__340.jpg","450 W 20th Ave","Shiho city BC","$2300000"))
        itemList.add(AllModel("https://cdn.pixabay.com/photo/2016/11/18/14/50/boat-1835081_960_720.jpg","450 W 20th Ave","Shiho city BC","$2300000"))
        itemList.add(AllModel("https://cdn.pixabay.com/photo/2018/03/07/02/41/japan-3205106__340.jpg","450 W 20th Ave","Shiho city BC","$2300000"))
        itemList.add(AllModel("https://cdn.pixabay.com/photo/2016/11/18/14/50/boat-1835081_960_720.jpg","450 W 20th Ave","Shiho city BC","$2300000"))
        allSavedAdapter.addAll(itemList)
    }
}
