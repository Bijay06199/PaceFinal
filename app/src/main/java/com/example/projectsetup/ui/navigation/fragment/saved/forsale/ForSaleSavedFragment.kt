package com.example.projectsetup.ui.navigation.fragment.saved.forsale

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectsetup.BR

import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.ForSaleSavedFragmentBinding
import com.example.projectsetup.databinding.ForSaleSavedFragmentBinding.inflate
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForSaleSavedFragment : BaseFragment<ForSaleSavedFragmentBinding,ForSaleSavedViewModel>() {

    private val forSaleSavedViewModel:ForSaleSavedViewModel by viewModel()
    override fun getLayoutId(): Int =R.layout.for_sale_saved_fragment
    override fun getViewModel(): ForSaleSavedViewModel = forSaleSavedViewModel
    override fun getBindingVariable(): Int {
       return BR.viewModel
    }

    companion object {
        fun newInstance() = ForSaleSavedFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       viewDataBinding=inflate(inflater,container,false)
        return viewDataBinding.root
    }



}
