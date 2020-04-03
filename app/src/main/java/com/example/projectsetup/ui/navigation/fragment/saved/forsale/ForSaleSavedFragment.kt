package com.example.projectsetup.ui.navigation.fragment.saved.forsale

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
import com.example.projectsetup.databinding.ForSaleSavedFragmentBinding
import com.example.projectsetup.databinding.ForSaleSavedFragmentBinding.inflate
import com.example.projectsetup.ui.navigation.fragment.saved.all.model.AllModel
import com.example.projectsetup.ui.navigation.fragment.saved.forrent.ForRentFragment
import com.example.projectsetup.ui.navigation.fragment.saved.forsale.adapter.ForSaleSavedAdapter
import com.example.projectsetup.ui.navigation.fragment.saved.forsale.model.ForSaleSavedModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForSaleSavedFragment : BaseFragment<ForSaleSavedFragmentBinding, ForSaleSavedViewModel>() {
    lateinit var forSaleSavedAdapter: ForSaleSavedAdapter
    private val forSaleSavedViewModel: ForSaleSavedViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.for_sale_saved_fragment
    override fun getViewModel(): ForSaleSavedViewModel = forSaleSavedViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    companion object {

        val TAG = ForSaleSavedFragment::class.java.simpleName
        fun start(activity: FragmentActivity, containerId: Int) {
            val fragment = ForSaleSavedFragment()
            activity.supportFragmentManager.beginTransaction()
                .addToBackStack(TAG)
                .replace(containerId, fragment)
                .commit()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {

        forSaleSavedAdapter = ForSaleSavedAdapter()
        viewDataBinding.recyclerViewForSaleSaved.adapter = forSaleSavedAdapter
        var itemList = ArrayList<ForSaleSavedModel>()
        itemList.add(
            ForSaleSavedModel(
                "https://cdn.pixabay.com/photo/2015/04/16/15/22/japan-725802__340.jpg",
                "450 W 20th Ave",
                "Shiho city BC",
                "$2300000"
            )
        )
        itemList.add(
            ForSaleSavedModel(
                "https://cdn.pixabay.com/photo/2015/04/16/15/22/japan-725802__340.jpg",
                "450 W 20th Ave",
                "Shiho city BC",
                "$2300000"
            )
        )
        itemList.add(
            ForSaleSavedModel(
                "https://cdn.pixabay.com/photo/2015/04/16/15/22/japan-725802__340.jpg",
                "450 W 20th Ave",
                "Shiho city BC",
                "$2300000"
            )
        )
        itemList.add(
            ForSaleSavedModel(
                "https://cdn.pixabay.com/photo/2015/04/16/15/22/japan-725802__340.jpg",
                "450 W 20th Ave",
                "Shiho city BC",
                "$2300000"
            )
        )
        itemList.add(
            ForSaleSavedModel(
                "https://cdn.pixabay.com/photo/2015/04/16/15/22/japan-725802__340.jpg",
                "450 W 20th Ave",
                "Shiho city BC",
                "$2300000"
            )
        )
        itemList.add(
            ForSaleSavedModel(
                "https://cdn.pixabay.com/photo/2015/04/16/15/22/japan-725802__340.jpg",
                "450 W 20th Ave",
                "Shiho city BC",
                "$2300000"
            )
        )
        itemList.add(
            ForSaleSavedModel(
                "https://cdn.pixabay.com/photo/2015/04/16/15/22/japan-725802__340.jpg",
                "450 W 20th Ave",
                "Shiho city BC",
                "$2300000"
            )
        )
        itemList.add(
            ForSaleSavedModel(
                "https://cdn.pixabay.com/photo/2015/04/16/15/22/japan-725802__340.jpg",
                "450 W 20th Ave",
                "Shiho city BC",
                "$2300000"
            )
        )

        forSaleSavedAdapter.addAll(itemList)
    }


}
