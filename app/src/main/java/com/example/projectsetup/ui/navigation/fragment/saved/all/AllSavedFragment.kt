package com.example.projectsetup.ui.navigation.fragment.saved.all

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectsetup.BR

import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.AllSavedFragmentBinding
import com.example.projectsetup.databinding.AllSavedFragmentBinding.inflate
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllSavedFragment : BaseFragment<AllSavedFragmentBinding,AllSavedViewModel>() {
    private val allSavedViewModel:AllSavedViewModel by viewModel()
    override fun getLayoutId(): Int =R.layout.all_saved_fragment
    override fun getViewModel(): AllSavedViewModel =allSavedViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    companion object {
        fun newInstance() = AllSavedFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       viewDataBinding=inflate(inflater,container,false)
        return viewDataBinding.root
    }



}
