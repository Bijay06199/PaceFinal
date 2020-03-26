package com.example.projectsetup.ui.navigation.fragment.saved.forrent

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment
import com.example.projectsetup.databinding.ForRentSavedFragmentBinding
import com.example.projectsetup.databinding.ForRentSavedFragmentBinding.inflate
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForRentSavedFragment : BaseFragment<ForRentSavedFragmentBinding,ForRentSavedViewModel>() {
    private val forRentSavedViewModel:ForRentSavedViewModel by viewModel()
    override fun getLayoutId(): Int =R.layout.for_rent_saved_fragment
    override fun getViewModel(): ForRentSavedViewModel =forRentSavedViewModel

    companion object {
        fun newInstance() = ForRentSavedFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       viewDataBinding=inflate(inflater,container,false)
        return viewDataBinding.root
    }



}
