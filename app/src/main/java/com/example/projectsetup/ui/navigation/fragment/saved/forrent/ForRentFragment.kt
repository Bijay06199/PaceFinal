package com.example.projectsetup.ui.navigation.fragment.saved.forrent

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectsetup.BR
import com.example.projectsetup.R
import com.example.projectsetup.base.BaseFragment

import com.example.projectsetup.databinding.ForRentFragmentBinding
import com.example.projectsetup.databinding.ForRentFragmentBinding.inflate
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForRentFragment : BaseFragment<ForRentFragmentBinding,ForRentViewModel>() {

    private val forRentViewModel:ForRentViewModel by viewModel()
    override fun getLayoutId(): Int = R.layout.for_rent_fragment
    override fun getViewModel(): ForRentViewModel =forRentViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    companion object {
        fun newInstance() =
            ForRentFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewDataBinding=inflate(inflater,container,false)
        return viewDataBinding.root

    }


    }


