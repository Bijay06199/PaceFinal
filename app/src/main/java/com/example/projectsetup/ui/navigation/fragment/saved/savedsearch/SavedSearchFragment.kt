package com.example.projectsetup.ui.navigation.fragment.saved.savedsearch

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment

import com.example.projectsetup.databinding.SavedSearchFragmentBinding
import com.example.projectsetup.databinding.SavedSearchFragmentBinding.inflate
import org.koin.androidx.viewmodel.ext.android.viewModel

class SavedSearchFragment : BaseFragment<SavedSearchFragmentBinding,SavedSearchViewModel>() {

    private val savedSearchViewModel:SavedSearchViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.saved_search_fragment
    override fun getViewModel(): SavedSearchViewModel =savedSearchViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    companion object {
        fun newInstance() =
            SavedSearchFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       viewDataBinding=inflate(inflater,container,false)
        return viewDataBinding.root

    }



}
