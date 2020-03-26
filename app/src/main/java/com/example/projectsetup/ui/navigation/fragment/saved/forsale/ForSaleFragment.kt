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

import com.example.projectsetup.databinding.ForSaleFragmentBinding
import com.example.projectsetup.databinding.ForSaleFragmentBinding.inflate
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForSaleFragment : BaseFragment<ForSaleFragmentBinding,ForSaleViewModel>(){

    private val forSaleViewModel:ForSaleViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.for_sale_fragment
    override fun getViewModel(): ForSaleViewModel = forSaleViewModel
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    companion object {
        fun newInstance() =
            ForSaleFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewDataBinding=inflate(inflater,container,false)
        return viewDataBinding.root
    }


}
