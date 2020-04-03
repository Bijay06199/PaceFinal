package com.example.projectsetup.ui.navigation.fragment.saved.savedsearch

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
import com.example.projectsetup.databinding.SavedSearchSavedFragmentBinding
import com.example.projectsetup.databinding.SavedSearchSavedFragmentBinding.inflate
import com.example.projectsetup.ui.navigation.fragment.saved.forsale.ForSaleFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SavedSearchSavedFragment : BaseFragment<SavedSearchSavedFragmentBinding,SavedSearchSavedViewModel>() {

    private val savedSearchSavedViewModel:SavedSearchSavedViewModel by viewModel()

    override fun getLayoutId(): Int =R.layout.saved_search_saved_fragment
    override fun getViewModel(): SavedSearchSavedViewModel = savedSearchSavedViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    companion object{

        val TAG= SavedSearchSavedFragment::class.java.simpleName
        fun start(activity: FragmentActivity, containerId:Int){
            val fragment= SavedSearchSavedFragment()
            activity.supportFragmentManager.beginTransaction()
                .addToBackStack(TAG)
                .replace(containerId,fragment)
                .commit()
        }
    }


}
